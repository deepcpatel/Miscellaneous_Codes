# Uniform Distribution Generator

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
            values[i][j] = float(prev_x)/float(m)
            c = c + 1

    return values

def info(random_vec, x_label = None, y_label = None, title = None):

    mean = np.mean(random_vec)
    std = np.std(random_vec)

    weights = np.ones_like(random_vec)/float(len(random_vec))   # To normalize the histogram
    plt.hist(random_vec, weights=weights)                       # Histogram
    plt.ylabel(y_label)
    plt.xlabel(x_label)
    plt.title(title + "\n" + "Mean: " + str(mean) + ", Standard Deviation: " + str(std))
    plt.show()

if __name__ == "__main__":

    quantity = 100000
    random_vec = uniform_random(quantity, 1)
    info(random_vec, 'Numbers', 'Probabilities', 'Uniform Distribution')
