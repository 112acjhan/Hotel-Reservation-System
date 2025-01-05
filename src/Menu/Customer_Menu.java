package Menu;

import Database.MySQL_db;
import Hotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Customer_Menu implements ActionListener {
    MySQL_db db = new MySQL_db();
    User global_customer;

    private JFrame f_customer_menu = new JFrame("Customer Menu");
    private JFrame f_hotel_reserve_menu = new JFrame("Hotel Reservation");

    public void Show_CustomerMenu(User customer){
        // Initiate
        global_customer = customer;
        JPanel p_user_selection = new JPanel();
        JLabel l_title = new JLabel("Customer Menu", SwingConstants.CENTER);
        JButton b_reservation = new JButton("Reserve Room");
        JButton b_reservation_cancel = new JButton("Cancel Reservation");
        JButton b_do_payment = new JButton("Payment");
        JButton b_log_out = new JButton("Log Out");

        // Font setting
        l_title.setFont(new Font("Poppins", Font.BOLD, 18));
        b_reservation.setFont(new Font("Poppins", Font.BOLD, 14));
        b_reservation_cancel.setFont(new Font("Poppins", Font.BOLD, 14));
        b_log_out.setFont(new Font("Poppins", Font.BOLD, 14));

        // Customer menu frame
        f_customer_menu.setLocationRelativeTo(null);
        f_customer_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_customer_menu.setVisible(true);
        f_customer_menu.setSize(400,300);
        f_customer_menu.add(l_title, BorderLayout.NORTH);
        f_customer_menu.add(p_user_selection, BorderLayout.CENTER);

        // Panel setting
        p_user_selection.setLayout(new GridLayout(6, 1));
        p_user_selection.setBorder(BorderFactory.createEmptyBorder(15, 50, 0, 50));
        p_user_selection.setBackground(Color.lightGray);
        p_user_selection.add(b_reservation);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(b_reservation_cancel);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(b_log_out);
        p_user_selection.add(new JLabel(""));

        // Button event setting
        b_reservation.addActionListener(this);
        b_reservation.setActionCommand("Reserve Hotel Menu");
        b_reservation_cancel.addActionListener(this);
        b_reservation_cancel.setActionCommand("Cancel Reserve Menu");
        b_log_out.addActionListener(this);
        b_log_out.setActionCommand("Log Out");
    }

    public void Show_hotel_menu(){
        // Get Hotel Details


        // Initiate
        String[] test = {"", "1", "2"};
        JPanel p_title = new JPanel();
        JPanel p_user_selection = new JPanel();
        JLabel l_title = new JLabel("Hotel Reservation", SwingConstants.CENTER);
        JLabel l_user_info = new JLabel("Username: " + global_customer.name);
        JLabel l_select_hotel = new JLabel("Select hotel:");
        JLabel l_select_room_type = new JLabel("Select room type:");
        JLabel l_select_room_number = new JLabel("Select room number:");
        JLabel l_select_checkInDate = new JLabel("Starting from (DD-MM-YYYY):");
        JLabel l_select_checkOutDate = new JLabel("Check Out at (DD-MM-YYYY):");
        JLabel l_select_paymentMethod = new JLabel("Payment Method:");
        JTextField tf_checkInDate = new JTextField(10);
        JTextField tf_checkOutDate = new JTextField(10);
        JComboBox<String> hotel_list = new JComboBox<>(test);
        JComboBox<String> room_type_list = new JComboBox<>();
        JComboBox<String> room_number_list = new JComboBox<>();
        JComboBox<String> payment_method_list = new JComboBox<>();
        tf_checkInDate.setEnabled(false);
        tf_checkOutDate.setEnabled(false);
        room_type_list.setEnabled(false);
        room_number_list.setEnabled(false);
        payment_method_list.setEnabled(false);

        // Font setting
        l_title.setFont(new Font("Poppins", Font.BOLD, 18));
        l_user_info.setFont(new Font("Poppins", Font.BOLD, 18));

        f_hotel_reserve_menu.setLocationRelativeTo(null);
        f_hotel_reserve_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f_hotel_reserve_menu.setVisible(true);
        f_hotel_reserve_menu.setSize(600,400);
        f_hotel_reserve_menu.add(p_title, BorderLayout.NORTH);
        f_hotel_reserve_menu.add(p_user_selection, BorderLayout.CENTER);

        // Panel setting
        p_title.setLayout(new GridLayout(2, 1));
        p_title.add(l_title);
        p_title.add(l_user_info);

        p_user_selection.setLayout(new GridLayout(12,2));
        p_user_selection.add(l_select_hotel);
        p_user_selection.add(hotel_list);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(l_select_room_type);
        p_user_selection.add(room_type_list);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(l_select_room_number);
        p_user_selection.add(room_number_list);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(l_select_checkInDate);
        p_user_selection.add(tf_checkInDate);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(l_select_checkOutDate);
        p_user_selection.add(tf_checkOutDate);
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(new JLabel(""));
        p_user_selection.add(l_select_paymentMethod);
        p_user_selection.add(payment_method_list);

        // Item Event
        hotel_list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    room_type_list.setEnabled(hotel_list.getSelectedIndex() != 0);
                }
            }
        });

        room_type_list.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    room_type_list.setEnabled(hotel_list.getSelectedIndex() != 0);
                }
            }
        });
    }


    public void actionPerformed(ActionEvent event){
        String command = event.getActionCommand();

        switch (command){
            case "Reserve Hotel Menu":
                f_customer_menu.dispose();
                Show_hotel_menu();
                break;

            case "Cancel Reserve Menu":
                System.out.println("Cancel");
                break;

            case "Log Out":
                f_customer_menu.dispose();
                Main_Menu main_menu = new Main_Menu();
                main_menu.show();
                break;
        }
    }
}
