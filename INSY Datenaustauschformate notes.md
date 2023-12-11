***
**Autor:** Manuel Fellner
**Version:** 04.12.2023

## 1. Datenaustauschformate

- Webserver ist zuständig für die Verwaltung von Adressdaten
- Wie können diese Daten (z.B. Liste aller Adressen) strukturiert an einen Client übertragen werden?

### 1.1 CSV

- **C**omma **S**eperated **V**alues
- Simple Textdateien mit speziellen Regeln
- Format für
	- Austausch zwischen Anwendungen
	- Übertragung im Web
	- Import- / Export-Funktionalitäten

#### Beispiel:

![](https://uploads.mfellner.com/XS8LkszY9KzU.png)

```csv
f. name;name;address;city;state
James;Smith;6649N Blue Gum St;New Orleans;LA
Jenna;Darakjy;4 B Blue Ridge Blvd;Brighton;MI
Art;Venere;8 W Cerritos Ave 54;Bridgeport;NJ
Lenna;Paprocki;639 Main St; Anchorage;AK
```

**Widerspruch:**

- CSV ist NICHT standardisiert!
- Lediglich allgemeine RFC-Beschreibung
- Nicht einmal der Zeichensatz ist geregelt
- Es gibt jedoch gängige Dialekte
- Mehrere mögliche Trennzeichen zwischen *Zellen*:
	- Semikolon ; Komma , Tabulator \t Doppelpunkt : Leerzeichen
- Mehrere mögliche Trennzeichen zwischen *Zeilen*:
	- Newline \n oder CRLF \r\n


**Wie stelle ich die Trennzeichen (z.B: ;) als Zeichen in einer Zelle dar?

![](https://uploads.mfellner.com/XfDlgh77seiN.png)

-> `"James;Peter";Smith;6649 N Blue Gum St;New Orleans;LA

- Zellen werden durch Anführungszeichen escaped

**Und wenn ich nun Anführungszeichen als Text verwenden möchte?

![](https://uploads.mfellner.com/1HgQChTzmGvz.png)

-> `"James;""Peter""";Smith;6649 N Blue Gum St;New Orleans;LA

- Anführungszeichen werden fürs Escapen verdoppelt

#### Zusammenfassung: CSV

- CSV-Dateien sind simple Textdateien mit speziellen Regeln
- Es gibt verschiedene Dialekte
- Eignen sich gut für tabellarische Informationen
- Eignen sich schlecht für:
	- hierarchische Beziehungen
	- referentielle Beziehungen
	- Unterstützung von Layout
	- Benutzerdefinierte Regeln (z.B. nur Zahlen, E-Mail-Adressen, etc.)

![](https://uploads.mfellner.com/XS8LkszY9KzU.png)

### 1.2 JSON


- **J**ava**S**cript **O**bject **N**otation
- Nur eine RFC-Beschreibung
- JSON-Dokumente sind valider JavaScript-Code, welcher 1:1 in JavaScript Objekte umgewandelt werden kann
- Wird aber auch in (fast allen) anderen Programmiersprachen verwendet
- Hauptanwendungsgebiete sind JavaScript-Applikationen, Ajax, Webapplikationen und Webservices

```json
[{
"first_name": "James",
"last_name": "Smith",
"address": "6649 N Blue Gum St",
"city": "New Orleans",
"state": "LA",
"zip": 70116,
"female": false,
"phones": ["504 -621 -8927", "504-845-1427"]
},
{
"first_name": "Jenna",
"last_name": "Darakjy",
"address": "4 B Blue Ridge Blvd",
"city": "Brighton",
"state": "MI",
"zip": 48116,
"female": true,
"phones": ["810 -292 -9388", "810 -374 -9840"]}]
```

- JSON kennt Datentypen
	- Strings, Boolean, Zahlen
	- null
	- Arrays (in eckigen Klammern `[]`)
	- Objekte (in geschwungenen Klammern `{}`)
- Objekte beinhalten eine (ungeordnete) Liste von EIgenschaften
- Eine Eigenschaft besteht aus einem Schlüssel und einem Wert (`key-value-pair`)
- Hierarchien können dargestellt werden.
- Einfache Repräsentation von Objekten der objektorientierten Programmierung
- Es sind jedoch keine komplexen Zusammenhänge darstellbar oder fortgeschrittene Validierungen möglich


### 1.3 XML


- E**x**tensible **M**arkup **L**anguage
- Eine Auszeichnungssprache
- Ebenfalls Textdokumente, die "menschenlesbar" sein sollen
- Strukturierte Darstellung von Informationen (ggf. auch inkl. benutzerdefinierten Regeln)
- Ebenfalls zur Serialisierung von Objekten geeignet
- Anwendung bei Webapplikation, Webservices, Konfigurationen, etc.
- Spezifikation von der W3C

```xml
<?xml version="1.0"?>
<menu>
  <food calories="650">
    <name>Belgian Waffles</name>
    <price>$5.95</price>
    <description>
      Two of our famous Belgian Waffles with plenty of real
      maple syrup
    </description>
  </food>
  <food calories="900">
    <name>Strawberry Belgian Waffles</name>
    <price>$7.95</price>
    <description>
      Light Belgian waffles covered with strawberries
    </description>
  </food>
</menu>
<menu>
  <food calories="650">
    <name>Belgian Waffles</name>
    <price>$5.95</price>
    <description>
      Two of our famous Belgian Waffles with plenty of real
      maple syrup
    </description>
  </food>
</menu>
```

- Es gibt immer nur genau ein Wurzelelement (root-element)
- Elemente werden geöffnet und müssen wieder geschlossen werden
- Elemente können weitere Elemente sowie Attribute beinhalten

## Zusammenfassung

- **CSV**
	- Einfaches tabellenbasiertes Format nach RFC-Empfehlungen
	- Keine Datentypen, Beziehungen, Layouts, Regeln
- **JSON**
	- RFC-Empfehlung mit hierarchischem Aufbau
	- Datentypen, Listen und Objekte als Key-Value-Pairs
	- Keine Validierung möglich
- **XML**
	- Komplexer W3C-Standard für saubere und wohlgeformte Dokumente
	- Beliebige verschachtelte Zusammenhänge
	- Validierung möglich
