---------BUILD SOURCE---------
Please open Eclipse on the given project, in Eclipse top menu click File -> Export.
Under the Export wizard select Java -> JAR File and then click Next.
Now select HeroesAndVillains folder and make sure that only the src folder is selected and then 
give a name and a directory to the .jar file you are creating,
for any other field present in the JAR Export wizard use the default option and then click Next.
In JAR Packaging Option leave as default options and click Next.
In Jar Manifest Specification the only command to change from default option is the application entry point which must be InitialDisplay class and then click finish. 
 
This will start the game and allow you to play.

---------RUNNING THE GAME---------

<--Windows-->
To run the game simply start the .jar executable file.
<--Linux-->
To run the game open a terminal window, cd into the folder where the game .jar file is and type the following command:
 java -jar <name_of_the_game>.jar

NOTE: After the game is opened the first time you will notice the GameSaves folder gets created and it contains two files needed to save the scores and the manager status.
Please do not delete the folder while the game is playing but feel free to delete this folder whenever the game is 
closed, the game will recreate the folders once you start the game again but the savings will be lost.


---------TESTING THE GAME---------
Please run our tests from the provided folder containing the program classes.
Please be patient with our tests as they complete withing 4 minutes, we have been 
thoroughly testing methods that delay secondary threads for this reason we have to wait a slightly long time for them to complete.