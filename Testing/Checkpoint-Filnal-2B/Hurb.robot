# Aloisio Teixeira Carvalho
# Turma 4


*** Settings *** 
Resource  ./Hurb.resource
library  SeleniumLibrary

*** Test Cases ***
Processo de reserva de pacote de viagens
  Acessar o site do Hurb
  Clicar em "Permitir todos os cookies"
  Selecionar a opção "Pacotes
  Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
  Selecionar um pacote de viagem
  Clicar em "ESCOLHER OPÇÃO"
  Escolher uma opção de viagem e clicar em "COMPRAR"
  Validar as informações da "Configuração" da viagem
  Validar as informações do período da viagem
  Selecionar a opção "Boleto parcelado"
  Preencher os dados de pagamento
  Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"
  Validar a informação sobre cancelamento grátis