from suds.client import Client
client = Client('http://www.webservicex.net/CurrencyConvertor.asmx?WSDL')

#FromCurrency = raw_input('Masukkan Currency Code: ')
#ToCurrency = raw_input('Masukkan Currency Code: ')

#result = client.service.ConversionRate(FromCurrency,ToCurrency)
result = client.service.ConversionRate('USD','IDR')

print "Hasil Konversi USD ke IDR : Rp.{0}".format(result)