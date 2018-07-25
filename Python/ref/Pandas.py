# Basic Pandas Functionality in ML
import pandas as pd
import numpy as np

# DataFrame: data table, with rows and named columns
    # Can be constructed by passing in dict with name : Series
    # Can also be loaded into a file
# Series: a column an a DataFrame
cityNames = pd.Series(["San Francisco", "Palo Alto", "Mountain View", "Cupertino"])
cityPop = pd.Series([5324, 5254, 7563, 2354])

table = pd.DataFrame({"City Names" : cityNames, "City Populations" : cityPop})

# print(cities['Population'][1:4])

#-- Loading from a file
calPop = pd.read_csv("https://storage.googleapis.com/mledu-datasets/california_housing_train.csv", sep = ",")
# print(calPop.head())

# apply lambda functions to Series, which returns a new Series
# review: lambda general form is: lambda [...args]: [function body]
assess = cityPop.apply(lambda val: val >= 5000)
# this is the same as this (numeric values only)
assess = cityPop >= 5000

# reindex (or shuffle) randomly with np.random
print(table)
print(np.random.permutation(table.index))
cityPop.reindex([3, 2, 1, 0])
print(cityPop)
