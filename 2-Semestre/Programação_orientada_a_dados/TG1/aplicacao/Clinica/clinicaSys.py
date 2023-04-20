from abc import ABC, abstractmethod
from datetime import date #usado para pegar a data para gerar os relatorios
import re   
hoje = date.today()
hoje = hoje.strftime('%d-%m-%Y')

class Pessoa(ABC):
    def __init__(self, name, cpf, bday, statusCivil):
        self.__name = name
        self.__cpf = cpf
        self.__bday = bday
        self.__statusCivil = statusCivil
        self.__hasError= False

    @abstractmethod
    def cadastrarDados():
        pass
    @abstractmethod
    def obterDados():
        pass
    
    @property
    def name(self):
        return self.__name
    @name.setter
    def name(self, novo):
        self.__name = novo

    @property
    def cpf(self):
        return self.__cpf
    @cpf.setter
    def cpf(self, novo):
        self.__cpf = novo

    @property
    def bday(self):
        return self.__bday
    @bday.setter
    def bday(self, novo):
        self.__bday = novo

    @property
    def statusCivil(self):
        return self.__statusCivil
    @statusCivil.setter
    def statusCivil(self, novo):
      self.__statusCivil = novo

    @property
    def hasError(self):
        return self.__hasError
    @hasError.setter
    def hasError(self, novo):
      self.__hasError = novo

    def __str__(self):
        return self.name + '||' + str(self.cpf) + '||' + self.bday + '||' + self.statusCivil

class Medico(Pessoa):
    def __init__(self, nome, cpf, bday, statusCivil, crm):
        super().__init__(nome, cpf, bday, statusCivil)
        self.__crm = crm

    @property
    def crm(self):
        return self.__crm
    @crm.setter
    def crm(self, novo):
        self.__crm = novo

    def internar(self, paciente):
        if paciente.convenio.creditos < 0:
            paciente.hasError = True
        elif not paciente.hasError:
            paciente.status = 'internado'
            paciente.convenio.creditos -= 500
            self.cadastrarDados(paciente)

    def diagnosticar(self, paciente, diagnostico):
        if paciente.convenio.creditos < 0:
            paciente.hasError = True
        elif not paciente.hasError:
            paciente.diagnostico = diagnostico
            paciente.convenio.creditos -= 150
            self.cadastrarDados(paciente)


    def liberar(self, paciente):
        paciente.status = 'liberado'
        self.cadastrarDados(paciente)

    def cadastrarDados(self, paciente):
        listaPacientes = self.obterDados()
        indexPaciente = -1
        for i, element in enumerate(listaPacientes):
            if paciente.cpf in element:
                indexPaciente = i
        listaPacientes[indexPaciente] = paciente.__str__()

        with GDA('saidas/pacientes.dat', 'w') as g:    
            for i, item in enumerate(listaPacientes):
                if i == len(listaPacientes)-1:
                    g.write(item)
                else:
                    g.write("%s\n" % item)

    def obterDados(self): #ler pacientes.dat
        f = open('saidas/pacientes.dat', 'r')
        return f.read().split('\n')

    def __str__(self):
        return super().__str__() + '||' + self.crm

class Enfermeira(Pessoa):
    def __init__(self, nome, cpf, bday, statusCivil, coren):
        super().__init__(nome, cpf, bday, statusCivil)
        self.__coren = coren

    @property
    def coren(self):
        return self.__coren
    @coren.setter
    def coren(self, novo):
        self.__coren = novo

    def gerarRelatorio(self, paciente, medico):
        if paciente.hasError:
            return

        fileName = 'rel_' + paciente.cpf
        filePath = 'saidas/relatorios/' + fileName + '.txt'
        f = open (filePath, 'w')
        f.write('Centro de pós-operatório do Hospital São Lucas\n\n################################################\n')
        f.write('\nData: ' + hoje)
        f.write('\nRelatamos que o paciente "'+ paciente.name + '", identificado pelo CPF: ' + paciente.cpf + ',')
        f.write('\nfoi atendido pelo médico "'+ medico.name + '", identificado pela credencial: ' + paciente.cpf + ',')
        f.write('\nSaldo do Convenio: ' + str(paciente.convenio.creditos) + '\nDiagnóstico Final: ' + paciente.diagnostico)

    def cadastrarPacientes(self, paciente):
        try:
            self.validarPaciente(paciente)
            listaPacientes = self.obterDados()
            for i in listaPacientes:
                if paciente.cpf in i:
                    return
            self.cadastrarDados(paciente)
        except ErroCpfInvalido:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroCpfInvalido]: ' + paciente.name + ' ' + paciente.cpf + '\n')
            paciente.hasError = True
        except ErroEstadoCivilInvalido:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroEstadoCivil]: ' + paciente.name + ' ' + paciente.statusCivil + '\n')
            paciente.hasError = True
        except ErroDataInvalida:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroDataInvalida]: ' + paciente.name + ' ' + paciente.bday + '\n')
            paciente.hasError = True
        except Exception:
            pass

    def cadastrarDados(self, paciente):
        f = open('saidas/pacientes.dat', 'a')
        f.write(paciente.__str__()+'\n')

    def obterDados(self): #ler pacientes.dat
        f = open('saidas/pacientes.dat', 'r')
        return f.read().split('\n')

    def validarPaciente(self, paciente):
        if len(paciente.cpf) != 11 or not paciente.cpf.isdigit():
            raise ErroCpfInvalido
        date_pattern = "^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{4}$"
        match = re.match(date_pattern, paciente.bday)
        if not match or int(paciente.bday.split('/')[2]) > 2022:
            raise ErroDataInvalida
        if paciente.statusCivil != 'Solteiro' and paciente.statusCivil != 'Casado':
            raise ErroEstadoCivilInvalido
        if paciente.hasError:
            raise Exception

    def __str__(self):
        return super().__str__() + '||' + str(self.coren)

class Secretaria(Pessoa):
    def __init__(self, nome, cpf, bday, statusCivil):
        super().__init__(nome, cpf, bday, statusCivil)

    @property
    def crm(self):
        return self.__crm
    @crm.setter
    def crm(self, novo):
        self.__crm = novo

    def cadastrarFuncionario(self, funcionario):
        try:
            self.validarFuncionario(funcionario)
            listaFuncionarios = self.obterDados()
            if funcionario.__str__() in listaFuncionarios:
                return
            self.cadastrarDados(funcionario)
        except ErroCpfInvalido:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroCpfInvalido]: ' + funcionario.name + ' ' + funcionario.cpf + '\n')
            funcionario.hasError = True
        except ErroEstadoCivilInvalido:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroEstadoCivil]: ' + funcionario.name + ' ' + funcionario.statusCivil + '\n')
            funcionario.hasError = True
        except ErroDataInvalida:
            f = open('saidas/erros.dat', 'a')
            f.write('[ErroDataInvalida]: ' + funcionario.name + ' ' + funcionario.bday + '\n')
            funcionario.hasError = True
        except Exception:
            pass
        

    def cadastrarDados(self, funcionario):
        with GDA('saidas/funcionarios.dat', 'a') as g:
            g.write(funcionario.__str__()+'\n')

    def obterDados(self): #ler pacientes.dat
        with GDA('saidas/funcionarios.dat', 'r') as g:
            return g.read().split('\n')

    def validarFuncionario(self, funcionario):
        if len(funcionario.cpf) != 11 or not funcionario.cpf.isdigit():
            raise ErroCpfInvalido
        date_pattern = "^[0-9]{1,2}\/[0-9]{1,2}\/[0-9]{4}$"
        match = re.match(date_pattern, funcionario.bday)
        if not match or int(funcionario.bday.split('/')[2]) > 2022:
            raise ErroDataInvalida
        if funcionario.statusCivil != 'Solteiro' and funcionario.statusCivil != 'Casado':
            raise ErroEstadoCivilInvalido
        if funcionario.hasError:
            raise Exception

class Paciente(Pessoa):
    def __init__(self, nome, cpf, bday, statusCivil, tipoConvenio, creditosConvenio):
        super().__init__(nome, cpf, bday, statusCivil)
        self.convenio = Convenio(tipoConvenio, creditosConvenio)
        self.__diagnostico = ''
        self.__status = ''

    @property
    def diagnostico(self):
        return self.__diagnostico
    @diagnostico.setter
    def diagnostico(self, novo):
        self.__diagnostico = novo

    @property
    def status(self):
        return self.__status
    @status.setter
    def status(self, novo):
        self.__status = novo

    def cadastrarDados():
        pass
    def obterDados():
        pass

    def __str__(self):
        if self.status == '':
            return super().__str__() + '||' + str(self.convenio) + '||' + self.diagnostico
        return super().__str__() + '||' + str(self.convenio) + '||' + self.diagnostico + '||' + self.status

class Convenio():
    def __init__(self,tipo,creditos):
        self.__tipo = tipo
        self.__creditos = creditos

    @property
    def tipo(self):
        return self.__tipo
    @tipo.setter
    def tipo(self,novo):
        self.__tipo = novo

    @property
    def creditos(self):
        return self.__creditos
    @creditos.setter
    def creditos(self,novo):
        if self.tipo == 'SUS':
            self.__creditos = 0
        else:
            self.__creditos = novo

    def __str__(self):
        return self.tipo + '-' + str(self.creditos)

class GDA():#gerenciador de arquivos
    def __init__(self,filename,mode):
        self.filename = filename
        self.mode = mode
        self.file = None

    def __enter__(self):
        self.file = open(self.filename,self.mode)
        return self.file

    def __exit__(self,exc_type,exc_value,exp_traceback):
        self.file.close()

class ErroCpfInvalido(BaseException):
    """CPFs devem ter 11 digitos e somente números"""
    pass
    
class ErroDataInvalida(BaseException):
    """Datas de nascimento devem conter somente numeros e seguir o modelo dia/mês/ano"""
    pass

class ErroEstadoCivilInvalido(BaseException):
    """Estado civil pode ser somente solteiro(a) ou casado(a) """
    pass
