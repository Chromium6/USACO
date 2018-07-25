# math and modelling
import math
#-- matplotlib
from matplotlib import cm
from matplotlib import gridspec
from matplotlib import pyplot as pp
#-- scikit learn
from sklearn import metrics
#-- base libraries
import numpy as np
import pandas as pd
import tensorflow as tf
from tensorflow.python.data import Dataset

# display preferences
tf.logging.set_verbosity(tf.logging.ERROR)

# load dataset and randomize data
calHousing = pd.read_csv("https://storage.googleapis.com/mledu-datasets/california_housing_train.csv", sep = ",")
calHousing.reindex(np.random.permutation(calHousing.index))
# normalize house value
calHousing['median_house_value'] /= 1000.0
#print(calHousing)#.describe())

# pass this info into tensorflow
# create a tensorflow column (this is more of a name, not the actual content)
featureName = calHousing[["total_rooms"]]
# assemble the actual data (in a type of tf feature column called a numeric column) called total rooms
featureData = [tf.feature_column.numeric_column("total_rooms")]

# define the label (or output)
targetName = calHousing[["median_house_value"]]

# hyperparameters
c = 0.0001 # learning rate

# create the LinearRegressor (from tf api)
mlModel = tf.train.GradientDescentOptimizer(c)
mlModel = tf.contrib.estimator.clip_gradients_by_norm(mlModel, 5.0)# use gradient clipping, which is a restrainer on gradient magnitude
# push data into model
linearRegression = tf.estimator.LinearRegressor(
    feature_columns = featureData,
    optimizer = mlModel
)

# input function: how the classifier takes in data, partitions it, formats it, etc. and how it rearranges and rabdomizes the sequence during training
# numEpochs: how many times the data is reused (None = indefinite times)
# @returns tuple (pair) of features and label
def myInputFunction(features, labels, tournamentSize=1, randomizing=True, numEpochs=None):
    # convert features (pandas dataframe) to a dict of numpy array
    features = {key:np.array(value) for key, value in dict(features).items()}
    # make a tf DataSet
    tfDataset = Dataset.from_tensor_slices((features, labels)) # max size 2GB
    tfDataset = tfDataset.batch(tournamentSize).repeat(numEpochs)
    # randomize
    if randomizing:
        tfDataset = tfDataset.shuffle(buffer_size=10000)
    # parse in next data batch
    features, labels = tfDataset.make_one_shot_iterator().get_next()
    return features, labels

# train function (pass in input function)
_ = linearRegression.train(input_fn = lambda: myInputFunction(featureName, targetName), steps = 100)

# evaluate your model
predictionFunction = lambda: myInputFunction(featureName, targetName, randomizing = False, numEpochs=1)
predictions = linearRegression.predict(input_fn=predictionFunction)
# convert array to numpy array for analysis
predictions = np.array([item['predictions'][0] for item in predictions])
# print analysis for this model
meanSquaredValue = metrics.mean_squared_error(predictions, targetName)
rootMeanSquaredValue = math.sqrt(meanSquaredValue)
#print("Mean squared value: %0.3f (harder to read)"% meanSquaredValue)

# find the range of error
minHousePrice = calHousing['median_house_value'].min()
maxHousePrice = calHousing['median_house_value'].max()
housePriceRange = maxHousePrice-minHousePrice

print("Housing prices range from %0.3f to %0.3f (%0.3f)" % (minHousePrice, maxHousePrice, housePriceRange))
print("Square root mean squared value: %0.3f (more normalized)"% rootMeanSquaredValue)
