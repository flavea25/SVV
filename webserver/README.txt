1. In order to run the program on your computer, you'll need to change the default path of the TestSite folder to the one on your computer; you can do this by either
	a) changing it in the code: class Config, line 10; or
	b) uncommenting the line from class WebServer and calling the setDefaultPath method with an appropriate path (line 21)

2. You can also change the port the server runs on by following the same instructions mentioned above.

3. The code contains TODO comments where it isn't completely implemented; however, I consider the code to be good enough for testing and the additional features wouldn't have been useful in this context.

4. If you don't use the TestSite provided in the lab and the main html page of your testing folder isn't named a.html (but index.html or maybe something else), you'll have to change the default in class Response, line 19.

5. I also included a maint.html page which will be opened when the server has the status MAINTENANCE; if your page is called something else, you'll have to change that default also from class Response, line 20.

6. I also included a simple CSS file called style.css in the folder, to test that feature as well; the testing folder from the laboratory didn't include one: therefor, I suggest you use the folder TestSite from my github; however, it shouldn't matter.