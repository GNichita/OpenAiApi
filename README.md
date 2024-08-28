# Simple Web Chat with Azure OpenAI

This project is a simple web-based chat interface that allows users to interact with Azure OpenAI. The chat interface
includes features such as copying the chat output to the clipboard and clearing the output.

## Features

- **System and User Messages**: Input fields to enter system and user messages.
- **Send Button**: Submits the messages to the server for processing.
- **Response Display**: Displays the response from Azure OpenAI.
- **Copy to Clipboard**: Copies the chat output to the clipboard.
- **Clear Output**: Clears the chat output.

## Project Structure

- **index.html**: The main HTML file containing the structure and layout of the web chat interface.
- **styles**: Inline CSS styles used for the layout and design of the web page.
- **JavaScript Functions**: Functions to handle sending messages, copying output to the clipboard, and clearing the
  output.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure you have JDK 17 or later installed.
- **Maven**: A project management tool that you can use to build the project.
- **Azure OpenAI Subscription**: An active subscription to Azure OpenAI services.
- **Spring Boot**: The application runs on a Spring Boot server.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/GNichita/OpenAiApi.git
   cd OpenAiApi

2. **Set up Azure OpenAI**:
    - Obtain your Azure OpenAI API key.
    - Update the `application.properties` file in the `src/main/resources` directory with your API key and endpoint
      information.

3. **Build the project**:
   ```bash
   mvn clean install
   
4. **Run the application**:
   ```bash
   mvn spring-boot:run

5. **Access the web interface**:
    - Open your browser and navigate to [http://localhost:8080](http://localhost:8080) to access the web interface.




