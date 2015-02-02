# CIJenkinsRobotium

Getting started Jenkins – Android Studio – Github - Robotium 
-	Download software
o	Download Jenkins war
o	Download Android SDK
o	Download Gradle

-	Set the path (environmental settings)
-	Create an android project (android Studio)
-	Share Project in Github (check other repository)
-	Install Jenkins or place into the web server
-	Check if the project is running (http://localhost:8082/jenkins/)
-	Configure android project with robotium
o	Add the library on the project or use gradle central repository
o	compile 'com.jayway.android.robotium:robotium-solo:5.2.1'
-	Set up the plugins
o	Manage >  Plugins (General and commun)
	GitHub
	Gradle
	Google Play store
	Ant Plugin
	Copy Artifact Plugin
	Credentials Plugin
	CVS Plugin
	External Monitor Job Type Plugin
	GIT client plugin
	GIT plugin
	GitHub API Plugin
	Github Authentication plugin
	GitHub plugin
	GitHub Pull Request Builder
	GitHub SQS Build Trigger Plugin
	Google OAuth Credentials plugin
	Google Play Android Publisher Plugin
	Gradle plugin
	Javadoc Plugin
	JUnit Plugin
	LDAP Plugin
	Mailer Plugin
	Matrix Authorization Strategy Plugin
	Matrix Project Plugin
	Maven Project Plugin
	OAuth Credentials plugin
	OWASP Markup Formatter Plugin
	PAM Authentication Plugin
	Port Allocator Plug-in
	SCM API Plugin
	SSH Agent Plugin
	SSH Credentials Plugin
	SSH Slaves plugin
	Subversion Plugin
	Translation Assistance Plugin
	Windows Slaves Plugin
	Green Balls
	Environment Injector Plugin - EnvInject Plugin

-	Set the email service ()
-	 Set up the project to get and commit the source code from the repository
o	Set the clone and git
o	Add Build step
	Gradle command
•	Description: Clean and build
•	Switches: --info –stacktrace
•	Task: clean app:assembleDebug :app:assembleDebugTest connectedCheck uninstallDebug uninstallDebugTest connectedAndroidTest (check to test in a virtual machine)
o	Copy the artefacts Post-build
	**\app\build\outputs\**
o	Send email in case of failure process.


Add client in google console and google play

 

 




Source
-	http://jenkins-ci.org/
-	http://www.vogella.com/tutorials/Robotium/article.html


