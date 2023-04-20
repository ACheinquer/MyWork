import os #importado para gerar uma lista com os arquivos na pasta operacoes e executar todos os arquios da pasta
from Clinica import clinicaSys as cs


def createPaciente(atributos):
    atributos = atributos.split(':')
    return cs.Paciente(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4], int(atributos[5]))

def createEnfermeira(atributos):
    atributos = atributos.split(':')
    return cs.Enfermeira(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4])

def createMedico(atributos):
    atributos = atributos.split(':')
    return cs.Medico(atributos[0], atributos[1], atributos[2], atributos[3], atributos[4])

def createSecretaria(atributos):
    atributos = atributos.split(':')
    return cs.Secretaria(atributos[0], atributos[1], atributos[2], atributos[3])

arr = os.listdir('../operacoes/')
for file in arr:
    filePath = '../operacoes/' + file
    with cs.GDA(filePath, 'r') as g:
        input = g.read()
    input = input.split('\n')
    separatorIndex = -1
    for i, element in enumerate(input):
        if element == '':
            separatorIndex = i
            break

    pessoas = input[:separatorIndex]
    comandos = input[separatorIndex+1:]
    atributos = []


    for i in pessoas:
        i = i.split('__')
        atributos.append(i[1])
    

    
    Paciente1 = createPaciente(atributos[0])
    Paciente2 = createPaciente(atributos[1])
    Enfermeira = createEnfermeira(atributos[2])
    Medico = createMedico(atributos[3])
    Secretaria = createSecretaria(atributos[4])
    
    



    for i in comandos:
        i = i.split('=')
        ativo = i[0]
        acao = i[1].split('->')
        passivo = acao[1]
        acao = acao[0]
        if ativo == 'Secretaria':
            if passivo == 'Secretaria':
                Secretaria.cadastrarFuncionario(Secretaria)
            if passivo == 'Medico':
                Secretaria.cadastrarFuncionario(Medico)
            if passivo == 'Enfermeira':
                Secretaria.cadastrarFuncionario(Enfermeira)
        if ativo == 'Enfermeira':
            if acao == 'cadastrar':
                if passivo == 'Paciente1':
                    Enfermeira.cadastrarPacientes(Paciente1)
                if passivo == 'Paciente2':
                    Enfermeira.cadastrarPacientes(Paciente2)
            if acao == 'relatorio':
                if passivo == 'Paciente1':
                    Enfermeira.gerarRelatorio(Paciente1, Medico)
                if passivo == 'Paciente2':
                    Enfermeira.gerarRelatorio(Paciente2, Medico)
        if ativo == 'Medico':
            if acao == 'liberar':
                if passivo == 'Paciente1':
                    Medico.liberar(Paciente1)
                if passivo == 'Paciente2':
                    Medico.liberar(Paciente2)
            if acao == 'internar':
                if passivo == 'Paciente1':
                    Medico.internar(Paciente1)
                if passivo == 'Paciente2':
                    Medico.internar(Paciente2)
            if acao == 'diagnosticar':
                passivo = passivo.split(':')
                if passivo[0] == 'Paciente1':
                    Medico.diagnosticar(Paciente1, passivo[1])
                if passivo[0] == 'Paciente2':
                    Medico.diagnosticar(Paciente2, passivo[1])
