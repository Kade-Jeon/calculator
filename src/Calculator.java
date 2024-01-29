import javax.swing.*;
import java.awt.*;

/*
* JFrame을 이용해 GUI형태로 구현하기 위해 JFrame을 상속받습니다.
* */
public class Calculator extends JFrame {

    private JTextField inputSpace;

    public Calculator(){
        setLayout(null); // 레이아웃 관리자를 사용하지 않음.

        inputSpace = new JTextField();
        inputSpace.setEditable(false);
        inputSpace.setBackground(Color.darkGray); // 배경색
        inputSpace.setHorizontalAlignment(JTextField.RIGHT);
        inputSpace.setFont(new Font("Arial", Font.BOLD, 50)); // 폰트설정
        inputSpace.setBounds(8, 10, 270, 70); //위치와 크기 설정 -> x:8, y:10 위치에 270 x 70 크기

        JPanel buttonPanel = new JPanel(); // 버튼을 담을 패널
        buttonPanel.setLayout(new GridLayout(4,4,10, 10)); // 그리드 레이아웃 사용, 가로 4칸 - 세로 4칸, 좌우 간격 10, 상하간격 10
        buttonPanel.setBounds(8, 90, 270, 235);

        String buttonNames[] = {
                "C","/","*","=",
                "7","8","9","+",
                "4","5","6","-",
                "1","2","3","0"
        };

        JButton buttons[] = new JButton[buttonNames.length];

        for (int i=0; i < buttonNames.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));

            if(i == 0) buttons[i].setBackground(Color.PINK);
            if((i >= 4 && i <=6) || (i >= 8 && i <=10) || (i >= 12 && i <=14)) buttons[i].setBackground(Color.GRAY);
            if ((i >= 1 && i <= 3) || i == 7 || i == 11) buttons[i].setBackground(Color.ORANGE);
            if(i == 15) buttons[i].setBackground(Color.GRAY);

            buttons[i].setForeground(Color.white); //글자색 흰색
            buttons[i].setBorderPainted(false); //테두리 없애기
            buttons[i].setOpaque(true);

            buttonPanel.add(buttons[i]);
            }

        add(inputSpace);
        add(buttonPanel);

        setTitle("계산기");
        setVisible(true);
        setSize(300, 370);
        setLocationRelativeTo(null); //띄울 때 화면 가운데 띄우며
        setResizable(false);//, 사이즈 조절을 불가능하게 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //CloseOperation을 설정해야 창을 닫을 때 실행중인 프로그램도 같이 종료됨

    }

    public static void main(String[] args) {
        new Calculator();

    }
}