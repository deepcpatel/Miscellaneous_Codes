import numpy as np
import matplotlib.pyplot as plt
from time import time

def LCG_Random(a, c, m, prev_x):
    return (a*prev_x + c) % m

def uniform_random(size_x = 1, size_y = 1): # Uniform random number generator between 0 and 1

    seed = int(('%.6f' % time()).split('.',1)[1])   # Seed depends on the current time
    prev_x = seed
    m = 2**31 - 1
    a = 7**5
    c = 0
    
    values = np.zeros([size_x, size_y], dtype = np.float32)

    for i in range(size_x):
        for j in range(size_y):
            prev_x = LCG_Random(a, c, m, prev_x)
            values[i][j] = (float(prev_x)/float(m))
            c = c + 1

    return values

def info(random_vec, x_label = None, y_label = None, title = None):

    mean = np.mean(random_vec)
    std = np.std(random_vec)

    weights = np.ones_like(random_vec)/float(len(random_vec))   # To normalize the histogram
    plt.hist(random_vec, weights=weights)                     # Histogram
    plt.ylabel(y_label)
    plt.xlabel(x_label)
    plt.title(title + "\n" + "Mean: " + str(mean) + ", Standard Deviation: " + str(std))
    plt.show()

def gaussian_random(x_size = 1, y_size = 1, mean = 0, std = 1):    # Guassian Random variable generator using box muller transform on ubiform distribution

    u1 = uniform_random(x_size, y_size)
    u2 = uniform_random(x_size, y_size)

    r = np.sqrt(-2*np.log(u1))
    theta = 2*np.pi*u2

    normal_boxMul_x = np.multiply(r, np.cos(theta))   # Box Muller Transform 1      
    normal_boxMul_y = np.multiply(r, np.sin(theta))   # Box Muller Transform 2

    return (mean + std * normal_boxMul_x), (mean + std * normal_boxMul_y)


if __name__ == "__main__":

    quantity = 10000

    res = uniform_random(quantity,1)[:,0]

    for i in range(10): # Adding Random Variables(See : https://www.dartmouth.edu/~chance/teaching_aids/books_articles/probability_book/Chapter7.pdf)
        res = np.convolve(res, uniform_random(quantity,1)[:,0], 'same')
    
    res = res/(10**35)  

    mean = np.mean(res)
    std = np.std(res)
    
    for i in range(len(res)):
        res[i] = (res[i] - mean)/std
    
    info(res, 'Numbers', 'Probability', 'Central Limit Theorem Experiment')
