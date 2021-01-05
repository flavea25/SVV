1. The GUI exists but it doesn't work properly since I was unable to use Threads correctly. However, I let it in, to see the results; 
it doesn't always load completely - if it doesn't look full, maximize and minimize the window again (see point 9).

Once you start the server (or put it in maintenance mode), the GUI will freeze and you won't be able to use it anymore:
	-in order to stop the server you'll have to manually Terminate/Disconnect from the Console;
	-in order to test the stopServer method, uncomment line 24 from class WebServer, so that the server is running when the GUI opens. 

2. You can run the project without the GUI component if you comment lines: 16, 36, 49, and 67 of class WebServer and uncomment line 24.


3. In order to run the program on your computer, you'll need to change the default path of the TestSite folder to the one on your PC; you can do this by either:
	a) changing it in the code: class Config, line 11; 
	b) uncommenting the line from class WebServer and calling the setDefaultPath method with an appropriate path (line 20); 
	c) through the GUI, when the server is STOPPED (don't forget to press SAVE!)
4. You can also change the port the server runs on by following the same instructions mentioned at point 2.


5. The code contains TODO comments where it isn't completely implemented; 
however, I consider the code to be good enough for testing and the additional features wouldn't have been useful in this context.


6. If you don't use the TestSite provided in the lab and the main HTML page of your testing folder isn't named a.html (but index.html or maybe something else), 
you'll have to change the default in class Response, line 18.
7. I also included a maint.html page which will be opened when the server has the status MAINTENANCE; 
if your maintenance page is called something else, you'll have to change that default also from class Response, line 19.
8. I also included a simple CSS file called style.css in the folder, to test that feature as well; the testing folder from the laboratory didn't include one: 
therefore, I suggest you use the folder TestSite from my GitHub; however, it shouldn't matter.


9. In the Results folder you'll be able to find:
	-Static & Dynamic Analysis
	-the WebServerGUI overlook - if it doesn't look like this when you run the project, maximize and minimize the GUI for it to update its appearance 
	-how the page looks in the browser when the WebServer is running - the text is red and the table has a border because of the CSS file.