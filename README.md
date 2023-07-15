#  Instruction on how to run
1. Clone repo:
   ```
   git clone git@github.com:lamnguyen03/QA_Engineer_Challenge.git
   ```
3. Install Java version 20, you can follow this tutorial: https://phoenixnap.com/kb/install-java-windows
4. Install maven, you can follow this tutorial: https://howtodoinjava.com/maven/how-to-install-maven-on-windows/
5. Open the terminal and Run
   
to run Test script with FireFox
``` mvn clean verify -Dwebdriver=firefox ```

or Chrome

```mvn clean verify -Dwebdriver=chrome```

or BrowserStack

```mvn clean verify -Dwebdriver=browserstack```

 to run the project which browser you want.
 
9. After running Test script, you can run this file to see the report.
 ![image](https://github.com/lamnguyen03/QA_Engineer_Challenge/assets/97352277/6c2be03e-90e7-4c09-a6f9-b77ea78213e3)

