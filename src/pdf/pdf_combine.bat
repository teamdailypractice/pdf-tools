@echo off
REM python pdf_tools.py split --help

SET INPUT_DATA_DIR=D:\git\pdf-tools\data
SET OUTPUT_DATA_DIR=D:\git\pdf-tools\output

set INPUT_FILE=ayyappan-temple-prayers.xlsx
SET OUTPUT_FILENAME=ayyappan-temple-prayers.pdf

python pdf_tools.py combine %INPUT_DATA_DIR%\%INPUT_FILE% %OUTPUT_DATA_DIR%\%OUTPUT_FILENAME%
