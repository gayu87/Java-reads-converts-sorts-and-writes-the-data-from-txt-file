# Java-reads-converts-sorts-and-writes-the-data-from-txt-file

Java console application that reads, converts, sorts, and writes planet data.  Create text file PlanetDataEnglish.txt, paste the following data into it, and place the file in your project folder.

PlanetDataEnglish.txt
Planet        Escape Velocity (miles/s)   Mean Temperature (F)    Number of Moons
Mercury                    2.7                   333                     0
Venus                      6.4                   867                     0
Earth                      7.0                    59                     1
Mars                       3.1                   -85                     2
Jupiter                   37.0                  -166                    67
Saturn                    22.1                  -220                    62
Uranus                    13.2                  -320                    27
Neptune                   14.6                  -330                    13
Pluto                      0.7                  -375                     5

Create the following methods:

Column	Purpose
readTextFile	To read the data from file PlanetDataEnglish.txt into four parallel arrays: planets, escapes, means, and moons.
printArrays	To print the unsorted, converted, and sorted data using the appropriate column headers.
convertArrays	To convert the escape velocities from miles/s to km/s, and to convert the mean temperatures from Fahrenheit to Celsius.
bubbleSortArray	To sort the data by planet name in ascending order.  Note that when values are swapped in one array, the same values must be swapped in the other arrays.  
writeTextFile	To write the data to file PlanetDataMetric.txt in the same layout as the input file.

Use the methods to:
1) Read the data.
2) Print the unsorted data.
3) Convert the data.
4) Print the converted data.
5) Bubble sort the data.
6) Print the sorted data.
7) Write the data.

Here are the first few lines of the output file:

PlanetDataMetric.txt
Planet        Escape Velocity (miles/s)   Mean Temperature (F)    Number of Moons
Earth                     11.3                    15                     1
Jupiter                   59.5                  -110                    67 …
