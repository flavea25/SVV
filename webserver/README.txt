1. The GUI exists but it doesn't work properly since I was unable to use Threads correctly. However, I let it in, to see the results; 
it doesn't always load completely - if it doesn't look full, maximize and minimize the window again 
(I attached a screenshot to this project of how it looks on my computer).
Once you start the server (or put it in maintenance mode), the GUI will freeze and you won't be able to use it anymore;
in order to test the stopServer method, uncomment line 22 from class WebServer, so that the server is running when the GUI opens. 

2. You can run the project without the GUI component if you comment lines: 14, 34, 47, and 65 of class WebServer and uncomment line 22.

3. In order to run the program on your computer, you'll need to change the default path of the TestSite folder to the one on your PC; you can do this by either:
	a) changing it in the code: class Config, line 10; 
	b) uncommenting the line from class WebServer and calling the setDefaultPath method with an appropriate path (line 18); 
	c) through the GUI, when the server is STOPPED (don't forget to press SAVE!)

4. You can also change the port the server runs on by following the same instructions mentioned at point 2.

5. The code contains TODO comments where it isn't completely implemented; 
however, I consider the code to be good enough for testing and the additional features wouldn't have been useful in this context.

6. If you don't use the TestSite provided in the lab and the main HTML page of your testing folder isn't named a.html (but index.html or maybe something else), 
you'll have to change the default in class Response, line 19.

7. I also included a maint.html page which will be opened when the server has the status MAINTENANCE; 
if your maintenance page is called something else, you'll have to change that default also from class Response, line 20.

8. I also included a simple CSS file called style.css in the folder, to test that feature as well; the testing folder from the laboratory didn't include one: 
therefore, I suggest you use the folder TestSite from my GitHub; however, it shouldn't matter.