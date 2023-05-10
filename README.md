# Hostbuddy_assignment

# Follow these steps to set up and run the application locally:

# Backend Setup
1. Download the project repository by clicking on the green "Code" button and selecting "Download ZIP."
2. Extract the downloaded ZIP file to your preferred location.
3. Open IntelliJ IDEA and select "Open" from the main menu.
4. Navigate to the extracted project folder (hostbuddy_assignment) and select it.
5. Wait for IntelliJ to import the project and resolve dependencies.
6. Once the project is loaded, run the backend application by finding the main class:
   com.example.HostBuddy_assignment.HostBuddyAssignmentApplication
   Right-click on the main class and select "Run" to start the backend server.

# Frontend Setup
1. Open your preferred code editor (e.g., Visual Studio Code).
2. Open the project folder (hostbuddy_assignment) in the code editor.
3. Locate the file index.html in the project folder.
4. Install the "Live Server" extension in Visual Studio Code if you haven't already.
5. Right-click on index.html and select "Open with Live Server" to start the frontend application in your default browser.

# Troubleshooting
1. If you encounter any issues, check the browser console for error messages. Right-click on the page, select "Inspect," 
   and navigate to the "Console" tab to view any errors.
2. If there are errors related to CORS (Cross-Origin Resource Sharing), you may need to update the backend configuration. Open ItemController.java located at:
   main => com.example.HostBuddy_assignment => controller => ItemController
3. Update line 16 to include the Live Server address printed in the console. Modify the @CrossOrigin annotation as follows:
   @CrossOrigin(origins = "{live_server_address}")
4. Save the file and restart the backend server.
Please note that the backend application must be running before accessing the frontend application. If you encounter any further issues, feel free to ask for assistance.

Thank you!
