# DataMining
<b><p align="center">
                                                 TECNOLÓGICO NACIONAL DE MÉXICO</br>
                                                INSTITUTO TECNOLÓGICO DE TIJUANA</br>
                                                      SUBDIRECCIÓN ACADÉMICA</br>
                                              DEPARTAMENTO DE SISTEMAS Y COMPUTACIÓN</br> 
                                                           PERIODO</br>
                                                      Enero - Junio 2020</br>
                                                           CARRERA</br>
                                               Ing. En Sistemas Computacionales</br>
                                                          ASIGNATURA</br> 
                                                Datos Masivos (BDD-1704 IF9A)</br>
                                                           DOCENTE</br>
                                                Jose Christian Romero Hernandez</br>
                                                           EQUIPO</br>
                                             16210958 - Aguirre Ibarra Jesus Armando</br>
                                             14212024 - Garcia Hernandez Victor David</br>                                                                                   
</p></b>

## Unit 2
### Index
[Homework 1](#id1)

[Homework 2](#id2)

[Homework 3](#id3)




***
## Homework 1  <a name="id1"></a>
### Main Types of Machine Learning Algorithms

The three groups of algorithms of machine learning

**1. Supervised learning**

In supervised learning, the machine is taught by example. In this way, the operator provides the machine learning algorithm with a known data set that includes the desired inputs and outputs, and the algorithm must find a method to determine how to get to those inputs and outputs.
While the operator knows the correct answers to the problem, the algorithm identifies patterns in the data, learns from the observations, and makes predictions. The algorithm makes predictions and is operator corrected, and this process continues until the algorithm reaches a high level of precision and performance.


**2. Unsupervised learning**

Here, the machine learning algorithm studies the data to identify patterns. There is no response key or human operator to provide instruction. Instead, the machine determines correlations and relationships by analyzing the available data.
In an unsupervised learning process, the machine learning algorithm is allowed to interpret large data sets and direct that data accordingly. Thus, the algorithm tries to organize that data in some way to describe its structure. This could mean the need to group the data into groups or organize it in a way that makes it look more organized.
As you evaluate more data, your ability to make decisions about it gradually improves and becomes more refined.


**3. Reinforcement learning**

Reinforcement learning focuses on regulated learning processes, where machine learning algorithms are provided with a set of actions, parameters, and end values.
By defining the rules, the machine learning algorithm attempts to explore different options and possibilities, monitoring and evaluating each result to determine which one is optimal.
Consequently, this system teaches the machine through the trial and error process. Learn from past experiences and begin to adapt your approach in response to the situation to achieve the best possible result.


**7 Types of machine learning algorithms**

**1. Regression algorithms**

In regression tasks, the machine learning program must estimate and understand the relationships between variables. Regression analysis focuses on one dependent variable and a number of other changing variables, making it particularly useful for prediction and forecasting.

**2. Bayesian algorithms**

These types of algorithms by classification are based on Bayes' theorem and classify each value as independent of any other. This allows predicting a class or category based on a given set of characteristics, using probability.
Despite its simplicity, the classifier works surprisingly well and is often used because it outperforms more sophisticated classification methods.

**3. Grouping algorithms**

They are used in unsupervised learning, and serve to categorize unlabelled data, that is, data without defined categories or groups.
The algorithm works by searching for groups within the data, with the number of groups represented by the variable K. Next, it works iteratively to assign each data point to one of the K groups according to the characteristics provided.

**4. Decision tree algorithms**

A decision tree is a tree structure similar to a flowchart that uses a branching method to illustrate every possible outcome of a decision. Each node within the tree represents a test on a specific variable, and each branch is the result of that test.

**5. Neural network algorithms**

An artificial neural network (RNA) comprises units arranged in a series of layers, each of which connects to the adjacent layers. RNAs are inspired by biological systems, such as the brain, and how they process information.
Thus, they are essentially a large number of interconnected processing elements, working in unison to solve specific problems.
They also learn by example and experience, and are extremely useful for modeling nonlinear relationships in high-dimensional data, or where the relationship between the input variables is difficult to understand.

**6. Dimension reduction algorithms**

Dimension reduction reduces the number of variables that are considered to find the exact information required.


**7. Deep Learning Algorithms**

Deep learning algorithms execute data through multiple layers of neural network algorithms, which move to a simplified representation of the data to the next layer.



***
## Homework 2  <a name="id2"></a>

#### VectorAssembler Library
``VectorAssembler`` is a transformer that combines a given list of columns into a single vector column. It is useful for combining raw features and features generated by different feature transformers into a single feature vector, in order to train ML models like logistic regression and decision trees. VectorAssembler accepts the following input column types: all numeric types, boolean type, and vector type. In each row, the values of the input columns will be concatenated into a vector in the specified order.
Examples

Assume that we have a DataFrame with the columns id, hour, mobile, userFeatures, and clicked:

 id | hour | mobile | userFeatures     | clicked
----|------|--------|------------------|---------
 0  | 18   | 1.0    | [0.0, 10.0, 0.5] | 1.0

userFeatures is a vector column that contains three user features. We want to combine hour, mobile, and userFeatures into a single feature vector called features and use it to predict clicked or not. If we set VectorAssembler’s input columns to hour, mobile, and userFeatures and output column to features, after transformation we should get the following DataFrame:

 id | hour | mobile | userFeatures     | clicked | features
----|------|--------|------------------|---------|-----------------------------
 0  | 18   | 1.0    | [0.0, 10.0, 0.5] | 1.0     | [18.0, 1.0, 0.0, 10.0, 0.5]


**Vectors Library**

Factory methods for ``org.apache.spark.ml.linalg.Vector``. We don't use the name Vector because Scala imports ``scala.collection.immutable.Vector by default``.

**How does rootMeanSquareError work?**

``rootMeanSquareError`` returns the root mean squared error, which is defined as the square root of the mean squared error.

The Mean Squared Error (MSE) is a measure of how close a fitted line is to data points. For every data point, you take the distance vertically from the point to the corresponding y value on the curve fit (the error), and square the value. Then you add up all those values for all data points, and, in the case of a fit with two parameters such as a linear fit, divide by the number of points minus two.[1] The squaring is done so negative values do not cancel positive values. The smaller the Mean Squared Error, the closer the fit is to the data. The MSE has the units squared of whatever is plotted on the vertical axis.

Another quantity that we calculate is the Root Mean Squared Error (RMSE). It is just the square root of the mean square error. That is probably the most easily interpreted statistic, since it has the same units as the quantity plotted on the vertical axis.

Key point: The RMSE is thus the distance, on average, of a data point from the fitted line, measured along a vertical line.

[1]: Using the number of points – 2 rather than just the number of points is required to account for the fact that the mean is determined from the data rather than an outside reference. This is a subtlety, but for many experiments, n is large so that the difference is negligible.

***
## Homework 3  <a name="id3"></a>

#### Pipeline and Confusion Matrix

**What is pipeline?**

A is specified as a sequence of stages, and each stage is either a or an . These stages are run in order, and the input is transformed as it passes through each stage. For stages, the method is called on the . For stages, the method is called to produce a (which becomes part of the , or fitted ), and that ’s method is called on the .PipelineTransformerEstimatorDataFrameTransformertransform()DataFrameEstimatorfit()TransformerPipelineModelPipelineTransformertransform()DataFrame
We illustrate this for the simple text document workflow. The figure below is for the training time usage of a .Pipeline
The method is called on the original , which has raw text documents and labels. The method splits the raw text documents into words, adding a new column with words to the . The method converts the words column into feature vectors, adding a new column with those vectors to the . Now, since is an , the first calls to produce a . If the had more s, it would call the ’s method on the before passing the to the next stage.PipelineTokenizerHashingTFTransformerLogisticRegressionEstimatorDataFramePipeline.fit()DataFrameTokenizer.transform()DataFrameHashingTF.transform()DataFrameLogisticRegressionEstimatorPipelineLogisticRegression.fit()LogisticRegressionModelPipelineEstimatorLogisticRegressionModeltransform()DataFrameDataFrame

**Matrix confusion**

In the field of artificial intelligence, a confusion matrix is ​​a tool that allows the visualization of the performance of an algorithm that is used in supervised learning. Each column in the array represents the number of predictions for each class, while each row represents the instances in the actual class. One of the benefits of confusion matrices is that they make it easy to see if the system is confusing two classes.
If the number of samples from different classes changes greatly in the input data, the classifier error rate is not representative of how well the classifier performs the task. If for example there are 990 samples from class 1 and only 10 from class 2, the classifier can easily have a bias towards class 1. If the classifier classifies all the samples as class 1, its precision will be 99%. This does not mean that it is a good classifier, as it had a 100% error in classifying class 2 samples.
In the example matrix below, of 8 real cats, the system predicted that three were dogs and out of six dogs predicted that one was a rabbit and two were cats. From the matrix it can be seen that the system has trouble distinguishing between cats and dogs, but that it can reasonably well distinguish between rabbits and other animals.





