# JsonVerifier
The project was made using Java 8 and Maven for the first stage of the recruitment process for Remitly Internship 2024. The program accepts the AWS::IAM::Role Policy JSON file, maps it to an object, checks if an input JSON Resource field contains a single asterisk, and logs the answer. The method that returns logical false if an input JSON Resource field contains a single asterisk and true in any other case is named checkResource(IAMRolePolicy policy) and is located in the JsonVerifier class.

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [License](#license)

## Installation
To use JsonVerifier, you need to have Java 8 installed on your system. You can download and install Java from [here](https://www.java.com/download/ie_manual.jsp).

After installing Java, you can clone this repository to your local machine using the following command:
```
git clone https://github.com/Alex4ndro5/JsonVerifier.git
```
## Usage
The project is run using the following command:
```
 java -jar JsonVerifier.jar <fileName>
```
Example:
```
 java -jar JsonVerifier.jar asterisk.json
```
The file must be located inside the resource folder (JsonVerifier/src/main/resources) to work. Only files with .json extension are accepted.
## License
This project is licensed under the [MIT License](LICENSE).
