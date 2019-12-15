import sys
from colordialog import ColorDialog
from iconChange import iconChange
from PyQt5 import QtWidgets
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtCore import *


class MainWindow(QtWidgets.QMainWindow):
    def __init__(self):
        super().__init__()
        self.color = Qt.green

        self.current = 0

        p = self.palette()
        p.setColor(QPalette.Background, QColor('green'))
        self.setPalette(p)

        colors_dialog = ColorDialog(self)
        iconDialog = iconChange(self)

        bar = self.menuBar()
        file_menu = bar.addMenu('Dialog')

        main_window_color = QAction('Kolor okna głównego', self)
        main_window_color.setCheckable(True)
        main_window_color.triggered.connect(lambda:colors_dialog.execute())

        change_color = QAction('Ustaw koła', self)
        change_color.setCheckable(True)

        change_icon = QAction('Ikona okn a glownego', self)
        change_icon.setCheckable(True)
        change_icon.triggered.connect(lambda :iconDialog.execute())

        file_menu.addAction(main_window_color)
        file_menu.addAction(change_color)
        file_menu.addAction(change_icon)

        self.initUI()
        self.qp = QPainter()

    def initUI(self):
        self.setGeometry(300, 300, 350, 300)
        self.setWindowTitle('Bezier curve')
        self.show()

    def paintEvent(self, e):
        self.qp.begin(self)
        self.qp.setPen(QPen(Qt.gray, 40, Qt.SolidLine))
        self.qp.drawEllipse(120, 100, 50, 50)
        self.qp.end()


class Window(QtWidgets.QWidget):
    def __init__(self, parent=None):
        super().__init__(self, parent)


if __name__ == '__main__':
    app = QtWidgets.QApplication(sys.argv)
    ex = MainWindow()
    sys.exit(app.exec_())
