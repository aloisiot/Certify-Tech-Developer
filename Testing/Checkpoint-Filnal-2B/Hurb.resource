# Aloisio Teixeira Carvalho
# Turma 4

*** Variables ***
${BROWSER}                                          chrome

*** Keywords ***
Acessar o site do Hurb
  Open Browser                                      http://hurb.com/br    ${BROWSER}

Clicar em "Permitir todos os cookies"
  Wait Until Element is Visible                     css=#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll
  Click Element                                     css=#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll

Selecionar a opção "Pacotes
  Click Element                                     css=#__next > div.Header_Header__1jiZz > div.hrc-2LOsj > div > div > div.h-91nvuq > div > button:nth-child(2)

Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
  Input Text                                        css=#downshift-1-input       Buenos Aires
  Click Element                                     XPath=//*[@id="__next"]/div[1]/div[2]/div/div/div[2]/button

Selecionar um pacote de viagem
  Click Element                                     css=#__next > div > main > div.ResultsCardsContainer_ResultsCardContainer__1jtiB > a:nth-child(1)
  Switch Window                                     NEW

Clicar em "ESCOLHER OPÇÃO"
  Click Element                                     css=body > div:nth-child(5) > section > div.box-offer-top.box-nopadding.col-sm-6.col-md-6 > div > section.box-offer-main.pull-left > div:nth-child(5) > div.pull-left.first-box > button

Escolher uma opção de viagem e clicar em "COMPRAR"
  Click Element                                     css=#offer-options > div.offer-options--items > div:nth-child(4) > div.row.flex > div.col-xs-12.col-sm-4.col-md-4.offer-options--box-right.main-package > div > div.col-xs-12.col-sm-7.col-md-7.offer-options--box.offer-options--box-price.flex > div:nth-child(2) > div:nth-child(4) > a

Validar as informações da "Configuração" da viagem
  Wait Until Element is Visible                     css=#dont-leave-banner > div > div > div > div.banner-package_button.dismiss.button
  Click Element                                     css=#dont-leave-banner > div > div > div > div.banner-package_button.dismiss.button
  Element Should Contain                            css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(7) > div > div > div:nth-child(2) > div.col-xs-8.col-sm-8.col-md-8.text-right         4 Noites\n1pessoa por pacote

Validar as informações do período da viagem
  Element Should Contain                            css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(9) > div > div > div:nth-child(2) > div.col-xs-7.col-sm-7.col-md-7.text-right.booking-info__date-formatted.summary-highlight       01 Ago 2022
  Element Should Contain                            css=body > div.container > div > div.col-md-4.col-sm-4.hidden-xs > div.summary > div:nth-child(9) > div > div > div:nth-child(3) > div.col-xs-7.col-sm-7.col-md-7.text-right.booking-info__date-formatted.summary-highlight       30 Jun 2023

Selecionar a opção "Boleto parcelado"
  Click Element                                     css=#ui-id-1
  Wait Until Element is Visible                     css=#dont-leave-banner > div > div > div > div.banner-package_button.dismiss.button
  Click Element                                     css=#dont-leave-banner > div > div > div > div.banner-package_button.dismiss.button

Preencher os dados de pagamento
  Input Text                                        css=#itxEmail          Joao da silva
  Input Text                                        css=#paymentMethods__bill > section > div:nth-child(2) > div:nth-child(2) > div > input        70512767009
  Input Text                                        css=#paymentMethods__bill > section > div:nth-child(2) > div:nth-child(3) > div > input        11990000000

Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"
  Select Checkbox                                   css=#cancellation-policy

Validar a informação sobre cancelamento grátis
  Element Should Contain                            css=#purchase-confirmation > div:nth-child(1) > div > div > div.free-cancellation-policy__message      Cancelamento Grátis!
