import csv
from datetime import date

current_date = date.today()

filename = "zametki.csv"
fieldnames = ['Date', 'Note']

def print_all_notes():
    try:
        with open(filename) as file:
            data_reader = csv.DictReader(file, delimiter=";")
            for line in data_reader:
                print(line)
    except FileNotFoundError:
        print("Ошибка, файл с заметками не найден")

def filter_notes_by_date(filter):
    count = 0
    try:
        with open(filename) as file:
            data_reader = csv.DictReader(file, delimiter=";")
            for line in data_reader:
                if(filter in str(line)):
                    count += 1
                    print(line)
            if(count == 0):
                print("На введенную дату ничего не найдено")
    except FileNotFoundError:
        print("Ошибка, файл с заметками не найден")

def add_notes(note):
    try:
        with open(filename, 'a', newline='') as file:
            writer = csv.DictWriter(file, fieldnames=fieldnames,  delimiter=";")
            if(len(note) != 0):
                writer.writerow({'Date': current_date, 'Note': note })
            else:
                print("Невозможно добавить пустую заметку")
    except FileNotFoundError:
        print("Ошибка, файл с заметками не найден")

if __name__ == "__main__":

    print('1 - для вывода всех заметок')
    print('2 - для поиска заметки по дате')
    print('3 - для добавления заметки')
    var = input("Введите действие: ")
    print("Вы ввели: " + var)

    if var == "1":
        print_all_notes()
    elif var == "2":
        print("Введите дату в формате ГГГГ-ММ-ДД: ")
        filter = input()
        filter_notes_by_date(filter)
    elif var == "3":
        print("Введите заметку: ")
        note = input()
        add_notes(note)
    else:
        print("incorrect")

