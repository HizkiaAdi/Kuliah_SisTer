from suds.client import Client
import xml.etree.ElementTree as ET
client = Client('http://www.webservicex.net/stockquote.asmx?WSDL')

#symbol = raw_input('Masukkan Code Perusahaan: ');
#result = client.service.GetQuote(symbol)
result = client.service.GetQuote('TLK')

tree = ET.ElementTree(ET.fromstring(result))  #read data from string lalu ubah ke tree
root = tree.getroot()

for element in root[0]:
    print "{0:17}: {1}".format(element.tag, element.text)