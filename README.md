# SoapUI

Additional projects for the API testing workshop.

The workshop video [«API Testing. Streamline your testing process. A step by step tutorial» by Andrii Olieinik](https://www.youtube.com/watch?v=x2ALtuCjuUo)

The slides [API Testing. Streamline your testing process](https://www.slideshare.net/oleynikandrey/api-testing-streamline-your-testing-process)

To run the maven SoapUI project and generate the JUnit-like reports execute cmd:

            cd api-test
            mvn clean test

To run the maven SoapUI project and generate the JUnit-like and surefire html reports execute cmd:

            cd api-test
            mvn surefire-report:report
