# PDF Tools

* Split Pdf
* Combine Pdf
* Create bookmarks
* Assumptions
  * currently works only with unprotected/without password pdf

## Language, tools

* Python
* VS Code

## Is python installed?

* Run the command: `python --version`
* What's the output?
* If python is installed, where: `where python`

## VS Code setup

* VS Code extension - **View -> Extensions** search and install
  * Python from Microsoft
  * Python Debugger from Microsoft
* Setup the **Python Profile**. How?
  * What is profile? <https://code.visualstudio.com/docs/editor/profiles>
* C + S + P -> Select Interpreter

## Steps

* `python -m venv venv`
* `venv\Scripts\activate.bat`
* `pip install typer`
* `pip install pymupdf`
* `pip install pandas`
* `pip install openpyxl`
* `pip freeze > requirements.txt`
* `pip install -r requirements.txt`
