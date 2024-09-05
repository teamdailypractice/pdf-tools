import typer
from os import path
from excel import process, combine_pdf

app = typer.Typer()


@app.command()
def split(specification_filepath:str):
    if path.exists(specification_filepath):
        print(f"Specification file exists: {specification_filepath}")
        process(specification_filepath)
    else:
        print(f"Specification file does not exist: {specification_filepath}")


@app.command()
def combine(specification_filepath: str, new_pdf_filepath:str):
    if path.exists(specification_filepath):
        print(f"Specification file exists: {specification_filepath}")
        combine_pdf(specification_filepath, new_pdf_filepath)
    else:
        print(f"Specification file does not exist: {specification_filepath}")


if __name__ == "__main__":
    app()
