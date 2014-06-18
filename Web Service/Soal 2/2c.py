from suds.client import Client
import xml.etree.ElementTree as ET
client = Client('http://www.webservicex.net/globalweather.asmx?WSDL')

#CityName = raw_input('Masukkan Nama Kota: ')
#CountryName = raw_input('Masukkan Nama Negara: ')

#result = client.service.GetWeather(CityName, CountryName).encode('UTF-16')
result = client.service.GetWeather('Jakarta', 'Indonesia').encode('UTF-16')

tree = ET.ElementTree(ET.fromstring(result))
root = tree.getroot()

print "\nHasil\n-----------------"

for element in root:
    print "{0:17}: {1}".format(element.tag, element.text)