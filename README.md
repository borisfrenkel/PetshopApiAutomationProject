**PetshopApiAutomationProject**

How to run:
1. Install Java version 1.5 or higher and add it to Path variable
2. Install maven and add it to Path variable
3. Open Command Prompt window
4. Change directory to PetshopApiAutomationProject
5. Run "mvn clean test" command


Dependencies:

Junit 5 - test runner and assertions

Apache HttpClient 5 - http requests

FasterXML Jackson - Json files parsing


Test cases:

**callFindByStatusApiWithStatusEqAvailableVerifyResponseBody**

**Steps:**
Call findByStatus API with input status=available, and receive a response
Call findByStatus API with input status=pending, and receive a response
Call findByStatus API with input status=sold, and receive a response
Extract all nodes that include Lion from response bodies

**Expected results:**
Responses should include nodes with Lion


**callFindByStatusApiWithStatusEqAvailableVerifyHttpStatus**

**Steps:**
Call findByStatus API with input status=available, and receive a response

**Expected results:**
Response should include SC_OK status


**callFindByStatusApiWithStatusEqPendingVerifyHttpStatus**

**Steps:**
Call findByStatus API with input status=pending, and receive a response

**Expected results:**
Response should include SC_OK status


**callFindByStatusApiWithStatusEqSoldVerifyHttpStatus**

**Steps:**
Call findByStatus API with input status=sold, and receive a response

**Expected results:**
Response should include SC_OK status


**callFindByStatusApiWithInputParameterEqNullVerifyHttpStatus**

**Steps:**
Call findByStatus API with input status=null, and receive a response

**Expected results:**
Response should include SC_BAD_REQUEST status