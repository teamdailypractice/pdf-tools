from typing import List
import pandas as pd
from dataclasses import dataclass
import pymupdf
import os


@dataclass
class PdfCombineFileDetails:
    """Input pdf and output pdf details"""
    sno: str
    source_filepath: str
    source_filename: str
    unit_name: str
    unit_number: str
    # bookmark_name: str

    def get_absolute_path(self, filepath, filename):
        return filepath + os.sep + filename

    def getSourceFileAbsolutePath(self):
        return self.get_absolute_path(self.source_filepath, self.source_filename)


@dataclass
class PdfFileDetails:
    """Input pdf and output pdf details"""
    sno: str
    source_filepath: str
    source_filename: str
    from_pageno: int
    to_pageno: int
    target_filepath: str
    target_filename: str
    unit_name: str
    unit_number: str
    topic: str

    def get_absolute_path(self, filepath, filename):
        return filepath + os.sep + filename

    def getSourceFileAbsolutePath(self):
        return self.get_absolute_path(self.source_filepath, self.source_filename)

    def getTargetFileAbsolutePath(self):
        file_extn = ".pdf"
        final_file_extn = ""

        if not self.target_filename.lower().endswith(file_extn):
            final_file_extn = file_extn

        return self.get_absolute_path(self.target_filepath, self.target_filename + final_file_extn)


def get_firstsheet(filepath: str):
    df = pd.read_excel(filepath, 0)
    for index, row in df.iterrows():
        print(row['sno'], index)


def get_combine_specification(filepath: str) -> List[PdfCombineFileDetails]:
    specifications = []
    df = pd.read_excel(filepath, 0)
    print(df)
    for index, row in df.iterrows():       
        if not pd.isna(row["source_filepath"]):            
            from_pageno = int(row['from_pageno'])
            if from_pageno >= 0:
                specification = PdfCombineFileDetails(row['sno'],
                                                    row['target_filepath'],
                                                    row['target_filename'],
                                                    row['unit_name'],
                                                    row['unit_number'],
                                                    )
                specifications.append(specification)

    return specifications


def get_specification(filepath: str) -> List[PdfFileDetails]:
    specifications = []
    df = pd.read_excel(filepath, 0)
    for index, row in df.iterrows():
        if not pd.isna(row["source_filepath"]):
            from_pageno = int(row['from_pageno'])
            if from_pageno >= 0:
                specification = PdfFileDetails(row['sno'],
                                            row['source_filepath'],
                                            row['source_filename'],
                                            row['from_pageno'],
                                            row['to_pageno'],
                                            row['target_filepath'],
                                            row['target_filename'],
                                            row['unit_name'],
                                            row['unit_number'],
                                            row['topic'],
                                            )
                specifications.append(specification)

    return specifications


def get_metadata():
    metadata = {}
    return metadata


def generate_pdf(specification: PdfFileDetails):
    source_pdf = pymupdf.open(specification.getSourceFileAbsolutePath())
    output_pdf = pymupdf.open()

    try:
        output_pdf.insert_pdf(
            source_pdf, from_page=int(specification.from_pageno)-1, to_page=int(specification.to_pageno) - 1)

        if os.path.exists(specification.getTargetFileAbsolutePath()):
            os.remove(specification.getTargetFileAbsolutePath())
        output_pdf.set_metadata(get_metadata())
        output_pdf.del_xml_metadata()
        output_pdf.save(specification.getTargetFileAbsolutePath(), garbage=4)
        print("completed generating new pdf: " +
              specification.getTargetFileAbsolutePath())
    finally:
        output_pdf.close()
        source_pdf.close()


def combine_pdf(specificationFilepath: str, targetPdfFilePath: str):
    output_pdf = pymupdf.open()
    all_toc = []
    TOC_LEVEL = 1
    try:
        items = get_combine_specification(specificationFilepath)
        print(items)
        for item in items:
            source_pdf = pymupdf.open(item.getSourceFileAbsolutePath())
            print(len(source_pdf))
            output_pdf.insert_pdf(source_pdf)
            print(item.unit_name)
            page_no = len(output_pdf) - len(source_pdf) + 1
            toc = [TOC_LEVEL, str(item.unit_number) + '_' + item.unit_name, page_no]
            all_toc.append(toc)
            # loc (list,tuple) – page location. Must be a valid (chapter, pno).
            source_pdf.close()
            source_pdf = None
    except Exception as err:
        print(f"Unexpected {err=}, {type(err)=}")
        raise
    else:
        if os.path.exists(targetPdfFilePath):
            os.remove(targetPdfFilePath)
        output_pdf.set_metadata(get_metadata())
        output_pdf.del_xml_metadata()
        output_pdf.set_toc(all_toc)
        output_pdf.save(targetPdfFilePath, garbage=4)
        print("completed generating new pdf: " + targetPdfFilePath)
    finally:
       output_pdf.close()
       output_pdf = None


def process(filepath: str):
    items = get_specification(filepath)
    for item in items:
        print(item)
        generate_pdf(item)


if __name__ == '__main__':
    filepath = "D:\\git\\python_tools_2022\\typer_practice\\data\\tn_10_em_science.xlsx"

# C:\data\tn_school_books\10th_Std_Science_EM_optimised.pdf


# set_toc_item(idx, dest_dict=None, kind=None, pno=None, uri=None, title=None, to=None, filename=None, zoom=0)