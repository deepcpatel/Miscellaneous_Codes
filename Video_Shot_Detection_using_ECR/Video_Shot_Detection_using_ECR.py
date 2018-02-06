# Reference : "Automatic shot boundary detection combining color, edge, and motion features of adjacent frames" paper
#             by A. Jacobs, A. Miene, G. T. Ioannidis, and O. Herzog

import sys
import cv2
import numpy as np

def ECR(frame, prev_frame, width, height, crop=True, dilate_rate = 3):

# Returns the edge-change-ratio
# The crop parameter can help you to reduce noises (e.g. subtitiles),
# the dilate_rate parameter controls the distance of the pixels between the frame
# and prev_frame

# Note : For videos 1.avi and 2.mp4, keep k = 10, dilate_rate = 5, crop = False

    safe_div = lambda x,y: 0 if y == 0 else x / y
    if crop:
        startY = int(height * 0.3)
        endY = int(height * 0.8)
        startX = int(width * 0.3)
        endX = int(width * 0.8)
        frame = frame[startY:endY, startX:endX]
        prev_frame = prev_frame[startY:endY, startX:endX]

    gray_image = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    edge = cv2.Canny(gray_image, 0, 200)
    dilated = cv2.dilate(edge, np.ones((dilate_rate, dilate_rate)))
    inverted = (255 - dilated)
    gray_image2 = cv2.cvtColor(prev_frame, cv2.COLOR_BGR2GRAY)
    edge2 = cv2.Canny(gray_image2, 0, 200)
    dilated2 = cv2.dilate(edge2, np.ones((dilate_rate, dilate_rate)))
    inverted2 = (255 - dilated2)
    log_and1 = (edge2 & inverted)
    log_and2 = (edge & inverted2)
    pixels_sum_new = np.sum(edge)
    pixels_sum_old = np.sum(edge2)
    out_pixels = np.sum(log_and1)
    in_pixels = np.sum(log_and2)
    return max(safe_div(float(in_pixels),float(pixels_sum_new)), safe_div(float(out_pixels),float(pixels_sum_old)))


if __name__ == "__main__":

    ecr_list = [] # Stores ECR value between curent and next frame
    list_size = 0 # Stores size of ecr_list

    temp1 = 0
    temp2 = 0
    temp3 = 0
    frame_no = 0

    video_title = "3.mp4" # Enter video name with extension

    file = open("Logs/Log_" + video_title + ".txt","w") # Made to keep watch on the values of variables, so that we can set the threshold properly
    video = cv2.VideoCapture('Videos/' + video_title)
    scale  = video.get(7) # Total frames in video
    print "\nCurrent Video : " + video_title
    print "\nTotal Frames : " + str(scale) + "\n"

    file.write("\nCurrent Video : " + video_title)
    file.write("\nTotal Frames : " + str(scale))

    k = 10
    frame_seq = k + 1

    width = video.get(cv2.cv.CV_CAP_PROP_FRAME_WIDTH)
    height = video.get(cv2.cv.CV_CAP_PROP_FRAME_HEIGHT)
    video.set(3, width)
    video.set(4, height)
    prev_frame = None
    while True:

        print "Current Frame : " + str(frame_seq)

        f = frame_seq # Current frame
        fp = f - 1 # Previous frame
        f_k = f - k
        fp_k = fp - k

        frame_no = f
        video.set(1,frame_no)
        ret, frame_f = video.read()

        frame_no = fp
        video.set(1,frame_no)
        ret, frame_fp = video.read()

        frame_no = f_k
        video.set(1,frame_no)
        ret, frame_f_k = video.read()

        frame_no = fp_k
        video.set(1,frame_no)
        ret, frame_fp_k = video.read()

        temp1 = ECR(frame_f, frame_f_k, width, height)
        temp2 = ECR(frame_f, frame_fp, width, height)
        temp3 = ECR(frame_fp, frame_fp_k, width, height)

        if temp2 != 0:
            r_nearfar = temp1 / temp2
        else:
            r_nearfar = temp1 / 0.001       # Setting

        if temp3 != 0:
            r_farlastfar = temp1 / temp3
        else:
            r_farlastfar = temp1 / 0.001    # Setting

        file.write("\n\n======="+str(frame_seq)+"=======")
        file.write("\nr_farlastfar : " + str(r_farlastfar))
        file.write(", r_nearfar : " + str(r_nearfar))

        if r_farlastfar > 3.0 or (r_farlastfar > 1.2 and r_nearfar > 2.5): # Threshold : 2.0, 3.0, 3.0 (Initial, Satic) for videos 1.avi and 2.mp4
            cv2.imwrite("Shot_Frames/Shot_Frame_%d.jpg" % frame_seq, frame_f)

        frame_seq = frame_seq + 1

        if frame_seq == scale:
            break

    file.close()
    video.release()
