
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

data_PrioExp <- "./PrioResultat/HeapExponentialResult.txt"
data_PrioNorm <-"./PrioResultat/HeapNormalResult.txt"
data_PrioUniform <- "./PrioResultat/HeapUniformResult.txt"


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

    model <- lm(Sorteringstid ~ Iteration*log(Iteration), data=data)
    #print(name) 
    #print(model)
    x_pred <- seq(min(data$Iteration), max(data$Iteration))
    y_pred <- predict(model, newdata = data.frame(Iteration = x_pred))
    lines(x_pred, y_pred, col = "green")
    legend("topright", legend = c("Exponential-fördelning", "Normalfördelning", "exponentialfördelning","tidskomplexitet"), col = c("black", "blue", "red","green"), lty = 1)
    dev.off()
    
    returnFrame <- data.frame(x_pred,y_pred)
    return (returnFrame)
}

plot4Graphs <- function(name,exp,norm,uni,prio){
    pdf(name)
    plot(exp$x_pred, exp$y_pred, type = "l", xlab = "Antal element", ylab = "Tidsåtgång [ns]")
    lines(norm$x_pred, norm$y_pred, col = "blue")
    lines(uni$x_pred, uni$y_pred, col = "red")

    lines(prio$x_pred, prio$y_pred, col = "green")
    legend("topright", legend = c("ArrayList", "LinkedList", "TreeMap","PriorityQueue"), col = c("black", "blue", "red","green"), lty = 1)
    dev.off()

}


array <- plot3Graphs("./ArrayListResultat/ArrayList.pdf",data_ArrayExp,data_ArrayNorm,data_ArrayUniform)
linked <- plot3Graphs("./LinkedResultat/LinkedList.pdf",data_LinkedExp,data_LinkedNorm,data_LinkedUniform)
tree <- plot3Graphs("./TreeResultat/TreeMap.pdf",data_TreeExp,data_TreeNorm,data_TreeUniform)
prio <- plot3Graphs("./PrioResultat/PrioQueue.pdf",data_PrioExp,data_PrioNorm,data_PrioUniform)
plot4Graphs("./CombinedResult/4graphs.pdf", array,linked,tree,prio)