
#Path to datafiles.
data_exp <- "./ExponentialDistribution.txt"
data_norm <-"./NormalDistribution.txt"
data_uniform <- "./UniformDistribution.txt"

data <- read.table(data_uniform, header = TRUE)

print(data)