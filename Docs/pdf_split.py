from pypdf import PdfReader, PdfWriter

reader = PdfReader("userguide.pdf")

# 목차 읽기
outlines = reader.outline

for i, item in enumerate(outlines):
    title = item.title
    start = reader.get_destination_page_number(item)

    if i + 1 < len(outlines):
        end = reader.get_destination_page_number(outlines[i + 1])
    else:
        end = len(reader.pages)

    writer = PdfWriter()

    for p in range(start, end):
        writer.add_page(reader.pages[p])

    with open(f"{title}.pdf", "wb") as f:
        writer.write(f)