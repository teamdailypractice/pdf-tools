# typst - how to generate pdf

* <https://typst.app/docs/tutorial/writing-in-typst/>
* filename - `filename.typ`

## Installations

* typst compiler
* vs code extension - **typst LSP**

## How to use?

```bash
# Creates `file.pdf` in working directory.
typst compile file.typ

# Creates PDF file at the desired path.
SET PROJECT_ROOT=D:\git\pdf-tools\typst-pdf
SET OUTPUT_PATH=D:\git\pdf-tools\typst-pdf\output
SET FILENAME=example-02
typst compile %FILENAME%.typ %OUTPUT_PATH%\%FILENAME%.pdf  
typst compile %FILENAME%.typ %OUTPUT_PATH%\%FILENAME%.pdf  --root %PROJECT_ROOT%
```

## images 

By NASA / Christy Hansen - http://www.nasa.gov/mission_pages/icebridge/multimedia/spr13/DSCN3043.html, Public Domain, https://commons.wikimedia.org/w/index.php?curid=25778382

## thirukkural

மு. வரதராசனார் உரை

## commands used

* cmd

```batch
cd D:\git\pdf-tools\typst-pdf\examples
SET FILENAME=a51
SET OUTPUT_PATH=D:\git\pdf-tools\typst-pdf\output
SET PROJECT_ROOT=D:\git\pdf-tools\typst-pdf
typst compile %FILENAME%.typ %OUTPUT_PATH%\%FILENAME%.pdf  --root %PROJECT_ROOT%
```

* bash `cd /d/git/spring-boot-learning/data-jpa-sqlite`

* bash tamil-vu - database:  `/d/git/tamilvu-thirukkural/output`
* Check the count `ls -l  muva_urai_1???.txt  | wc -l`
* powershell `copy-item D:\git\spring-boot-learning\data-jpa-sqlite\data-out\thirukkural-muva-urai.typ D:\git\pdf-tools\typst-pdf\examples\a61.typ
`

https://www.tamilvu.org/library/l2100/html/l2100ind.htm