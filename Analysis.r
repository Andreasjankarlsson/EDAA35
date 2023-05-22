
#Path to datafiles.

data_ArrayExp <- "./ArrayListResultat/ArrayListExponentialResult.txt"
data_ArrayNorm <-"./ArrayListResultat/ArrayListNormalResult.txt"
data_ArrayUniform <- "./ArrayListResultat/ArrayListUniformResult.txt"


data_LinkedExp <- "./LinkedResultat/LinkedExponentialResult.txt"
data_LinkedNorm <-"./LinkedResultat/LinkedNormalResult.txt"
data_LinkedUniform <- "./LinkedResultat/LinkedUniformResult.txt"

data_TreeExp <- "./TreeResultat/TreeExponentialResult.txt"
data_TreeNorm <-"./TreeResultat/TreeNormalResult.txt"
data_TreeUniform <- "./TreeResultat/TreeUniformResult.txt"


plotresult <- function(file, start = 1) {
   data <- read.csv(file)
   data <- data[start:nrow(data),]
   plot(data, type = 'l')
}

getXValues <- function(file, start =1){
    data <- read.csv(file)
    data <- data$Iteration
    return(data)
}
getYValues <- function(file, start=1){
    data <- read.csv(file)
    data <- data$Sorteringstid
    return(data)
}

plot3Graphs <- function(name,exp,norm,uni){
    pdf(name)
    plot(getXValues(exp), getYValues(exp), type = "l", xlab = "Antal element", ylab = "Tidsåtgång [ns]")
    lines(getXValues(norm), getYValues(norm), col = "blue")
    lines(getXValues(uni), getYValues(uni), col = "red")

    dataExp <- read.csv(exp)[-1,]$Sorteringstid
    dataNorm <- read.csv(norm)[-1,]$Sorteringstid
    dataUni <- read.csv(uni)[-1,]$Sorteringstid
    combinedData <- data.frame(dataExp,dataNorm,dataUni)
    meanRow <- rowMeans(combinedData)
    xValues <- read.csv(exp)[-1,]$Iteration

    data <- data.frame(xValues,meanRow)
    colnames(data) <- c("Iteration", "Sorteringstid")
    print(data)

    model <- lm(Sorteringstid ~ Iteration*log(Iteration), data=data)
    x_pred <- seq(min(data$Iteration), max(data$Iteration))
    y_pred <- predict(model, newdata = data.frame(Iteration = x_pred))
    lines(x_pred, y_pred, col = "green")
    legend("topright", legend = c("Exponential-fördelning", "Normalfördelning", "exponentialfördelning","tidskomplexitet"), col = c("black", "blue", "red","green"), lty = 1)
    dev.off()
}


plot3Graphs("./ArrayListResultat/ArrayList.pdf",data_ArrayExp,data_ArrayNorm,data_ArrayUniform)
plot3Graphs("./LinkedResultat/LinkedList.pdf",data_LinkedExp,data_LinkedNorm,data_LinkedUniform)
plot3Graphs("./TreeResultat/TreeMap.pdf",data_TreeExp,data_TreeNorm,data_TreeUniform)

