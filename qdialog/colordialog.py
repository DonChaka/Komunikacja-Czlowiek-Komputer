import sys

from PyQt5 import QtSql
from PyQt5.QtCore import Qt
from PyQt5.QtGui import QStandardItem, QColor, QPalette
from PyQt5.QtWidgets import QDialog, QComboBox, QVBoxLayout


class ColorDialog(QDialog):
    def __init__(self, window):
        super().__init__()

        colors = [['czerwony', 'red'], ['zielony', 'green'], ['niebieski', 'blue'], ['żółty', 'yellow']]

        self.combo = QComboBox()
        model = self.combo.model()
        for color in colors:
            item = QStandardItem()
            item.setText(color[0])
            item.setBackground(QColor(color[1]))
            model.appendRow(item)

        layout = QVBoxLayout()
        layout.addWidget(self.combo)
        self.setLayout(layout)
        self.combo.currentIndexChanged.connect(lambda: self.changeColor(window))
        self.setModal(0)

    def execute(self):
        self.show()

    def changeColor(self, window):
        color = self.combo.currentText()
        switcher = {
            'czerwony': 'red',
            'zielony': 'green',
            'niebieski': 'blue',
            'żółty': 'yellow'
        }
        p = window.palette()
        p.setColor(QPalette.Background, QColor(switcher[color]))
        window.setPalette(p)