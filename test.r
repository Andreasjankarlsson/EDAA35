x <- 1:10
y <- c(1, 5, 12, 22, 35, 51, 70, 92, 117, 145)

# Fit the line log(N) * N
fit <- lm(log(y) ~ x)

# Generate x-values for the line
x_line <- seq(min(x), max(x), length.out = 100)

# Predict y-values using the fitted model
y_line <- exp(predict(fit, newdata = data.frame(x = x_line)))

# Plot the dataset and the fitted line
pdf("test.pdf")
plot(x, y, pch = 16, col = "black", xlab = "X", ylab = "Y")
lines(x_line, y_line, col = "red", lwd = 2)
dev.off()