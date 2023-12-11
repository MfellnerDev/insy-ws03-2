from flask import Flask, render_template
import xml.etree.ElementTree as ET

app = Flask(__name__)

def parse_xml(xml_file):
    tree = ET.parse(xml_file)
    root = tree.getroot()
    books = []

    for book_elem in root.findall("book"):
        title = book_elem.find("title").text
        language = book_elem.find("title").get("lang")
        author = book_elem.find("author").text
        year = book_elem.find("year").text
        price = book_elem.find("price").text
        category = book_elem.get("category")

        books.append({
            "title": title,
            "language": language,
            "author": author,
            "year": year,
            "price": price,
            "category": category
        })

    return books

@app.route('/parse')
def parse_and_display():
    books = parse_xml("book_store.xml")
    return render_template('books.html', books=books)

if __name__ == '__main__':
    app.run()
