from PyQt5 import uic
from PyQt5.QtGui import *
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from ui_window import *


class iconChange(QDialog):
    def __init__(self, window):
        super().__init__()

        self.window = window

        self.ui = Ui_Dialog()
        self.ui.setupUi(self)
        self.ui.retranslateUi(self)

        self.ui.okButton.clicked.connect(lambda: self.changeIcon(window))
        self.ui.cancelButton.clicked.connect(lambda: self.close())

        self.frame = QFrame(self)
        self.frame.setGeometry(QRect(10, 10, 101, 111))
        self.frame.setFrameShape(QFrame.StyledPanel)
        self.frame.setFrameShadow(QFrame.Raised)
        self.frame.setObjectName("frame")
        self.wesolaRadio = QRadioButton(self.frame)
        self.wesolaRadio.setGeometry(QRect(10, 10, 82, 17))
        self.wesolaRadio.setObjectName("wesolaRadio")
        self.wesolaRadio.toggled.connect(lambda: self.setHappy())
        self.normalnaRadio = QRadioButton(self.frame)
        self.normalnaRadio.setGeometry(QRect(10, 40, 82, 17))
        self.normalnaRadio.setObjectName("normalnaRadio")
        self.normalnaRadio.toggled.connect(lambda: self.setNormal())
        self.smutnaRadio = QRadioButton(self.frame)
        self.smutnaRadio.setGeometry(QRect(10, 70, 82, 17))
        self.smutnaRadio.setObjectName("smutnaRadio")
        self.smutnaRadio.toggled.connect(lambda: self.setSad())
        self.frame_2 = QFrame(self)
        self.frame_2.setGeometry(QRect(10, 130, 101, 111))
        self.frame_2.setFrameShape(QFrame.StyledPanel)
        self.frame_2.setFrameShadow(QFrame.Raised)
        self.frame_2.setObjectName("frame_2")
        self.wesolaCheckbox = QCheckBox(self.frame_2)
        self.wesolaCheckbox.setGeometry(QRect(10, 10, 70, 17))
        self.wesolaCheckbox.setObjectName("wesolaCheckbox")
        self.smutnaCheckbox = QCheckBox(self.frame_2)
        self.smutnaCheckbox.setGeometry(QRect(10, 70, 70, 17))
        self.smutnaCheckbox.setObjectName("smutnaCheckbox")
        self.normalnaCheckbox = QCheckBox(self.frame_2)
        self.normalnaCheckbox.setGeometry(QRect(10, 40, 70, 17))
        self.normalnaCheckbox.setObjectName("normalnaCheckbox")
        self.okButton = QPushButton("Ok")
        self.okButton.setGeometry(QRect(310, 20, 75, 23))
        self.okButton.setObjectName("okButton")
        self.okButton.clicked.connect(lambda: self.changeIcon(window))
        self.cancelButton = QPushButton("Cancel")
        self.cancelButton.setGeometry(QRect(310, 50, 75, 23))
        self.cancelButton.setObjectName("cancelButton")
        self.cancelButton.clicked.connect(lambda: self.closeIt)
        self.progressBar = QProgressBar(self)
        self.progressBar.setGeometry(QRect(120, 170, 31, 71))
        self.progressBar.setProperty("value", 0)
        self.progressBar.setOrientation(Qt.Vertical)
        self.progressBar.setObjectName("progressBar")
        self.iconView = QLabel(self)
        self.iconView.setGeometry(QRect(130, 10, 141, 141))
        self.iconView.setObjectName("iconView")

        if window.current == 1:
            self.wesolaRadio.setChecked(True)
        elif window.current == 2:
            self.normalnaRadio.setChecked(True)
        elif window.current == 3:
            self.smutnaCheckbox.setChecked(True)

    def closeIt(self):
        self.close()

    def execute(self):
        self.show()

    def setSad(self):
        self.window.current = 3
        self.icon = QIcon("sad.png")
        self.pixmap = QPixmap('sad.png')
        self.iconView.setPixmap(self.pixmap.scaled(141,141))
        self.progressBar.setValue(0)
        self.normalnaCheckbox.setChecked(False)
        self.smutnaCheckbox.setChecked(True)
        self.wesolaCheckbox.setChecked(False)

    def setHappy(self):
        self.window.current = 1
        self.icon = QIcon("happy.png")
        self.pixmap = QPixmap('happy.png')
        self.iconView.setPixmap(self.pixmap.scaled(141,141))
        self.progressBar.setValue(100)
        self.normalnaCheckbox.setChecked(False)
        self.wesolaCheckbox.setChecked(True)
        self.smutnaCheckbox.setChecked(False)

    def setNormal(self):
        self.window.current = 2
        self.icon = QIcon("normal.png")
        self.pixmap = QPixmap('normal.png')
        self.iconView.setPixmap(self.pixmap.scaled(141,141))
        self.progressBar.setValue(50)
        self.normalnaCheckbox.setChecked(True)
        self.wesolaCheckbox.setChecked(False)
        self.smutnaCheckbox.setChecked(False)

    def changeIcon(self, window):
        window.setWindowIcon(self.icon)
