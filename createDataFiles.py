import numpy as np
import os

def createNormalDistributionFile():
    N = 100000
    fileName = "NormalDistribution.txt"
    mu, sigma = 50, 1 # mean and standard deviation
    numbers = np.random.normal(mu, sigma, N)
    
    outputString = ""
    for number in numbers:
        outputString += str(number) +"\n"
        
    if os.path.exists(fileName):
        os.remove(fileName)

    with open(fileName, 'a') as f:
        f.write(outputString[:-1])

def createExponentialDistributionFile():
    N = 100000
    fileName = "ExponentialDistribution.txt"

    outputString = ""

    numbers = np.random.exponential(scale=1.0, size=N)
    for number in numbers:
        outputString += str(number) + "\n"

    if os.path.exists(fileName):
        os.remove(fileName)

    with open(fileName, 'a') as f:
        f.write(outputString[:-1])


def createUniformDistributionFile():
    N = 100000
    fileName = "UniformDistribution.txt"

    outputString = ""
    numbers = np.random.uniform(low=0.0, high=1.0, size=N)

    for number in numbers:
        outputString += str(number) + "\n"

    if os.path.exists(fileName):
        os.remove(fileName)

    with open(fileName, 'a') as f:
        f.write(outputString[:-1])


createExponentialDistributionFile()
createNormalDistributionFile()
createUniformDistributionFile()