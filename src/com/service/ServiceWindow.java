package com.service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.client.User;


public class ServiceWindow extends JFrame implements ActionListener{
	
	// �������������
	Vector vData = new Vector();
	private JTable table;
	int index=-1;
	private JTextArea jta;
	ChatServer chatserver;
	private JButton start;
	public ServiceWindow(){//����������
		this.setBounds(200, 300, 600, 500);
		Layout();
		this.setLocationRelativeTo(null);
	    this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public void Layout(){//���ڲ���
		 // �����������������ָ��ʹ�� �߽粼��
        JPanel panel = new JPanel(new BorderLayout());
        JPanel bto=new JPanel();
        start = new JButton("����");
        start.setActionCommand("0x111");
        start.addActionListener(this);
        JButton del = new JButton("ɾ���û�");
        del.setActionCommand("0x112");
        del.addActionListener(this);
        panel.setLayout(new BorderLayout());
		JSplitPane jsp=new JSplitPane();
		JPanel left=new JPanel();
		JPanel right=new JPanel();
		jta = new JTextArea(15,24);
		DefaultTableModel dtm= new DefaultTableModel(null,ChatServer.getData());
		table = new JTable(dtm); 
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		
		cellSelectionModel.addListSelectionListener(new ListSelectionListener(){
 
			public void valueChanged(ListSelectionEvent e) {//��Ԫ��ֵ�䶯�¼�
				String selectedData = null;
				int selectedRow = table.getSelectedRow();//��ѡ�����
			    if(selectedRow>-1){
			    	index=selectedRow;
			       }
				
			}
	         
		
		
		});
		JScrollPane JST=new JScrollPane(table);
		JST.setPreferredSize(new Dimension(280, 380));
		jta.setFont(new Font("����", Font.PLAIN, 18));
		
		jta.setEditable(false);
		JScrollPane jsl=new JScrollPane(jta);
		jsl.setPreferredSize(new Dimension(270, 380));
		left.setBorder(BorderFactory.createTitledBorder("��Ϣ��¼"));
		right.setBorder(BorderFactory.createTitledBorder("�����û�"));
		jta.setLineWrap(true);
		left.add(jsl); 
		right.add(JST);
		// ���÷ָ����ĳ�ʼλ��
        jsp.setDividerLocation(280);
		jsp.setLeftComponent(left);
		jsp.setRightComponent(right);
		panel.add(jsp,BorderLayout.NORTH);
		panel.add(bto,BorderLayout.SOUTH);
		bto.add(start);
		bto.add(del);
		this.add(panel);
		chatserver=new ChatServer(jta,table,vData,this);
		
	}
    @Override
	public void actionPerformed(ActionEvent e) {
	String id=	e.getActionCommand();
	if(id.equals("0x111")){//����������
		chatserver.startServer();
		start.setText("�ر�");//���ð�ťΪ�ر�
		start.setActionCommand("0x113");
	}
	else
	if(id.equals("0x112")){//�ڷ��������Ƴ��ͻ��˳�Ա
		if(index>-1){
			vData.remove(index);
			index=-1;
			DefaultTableModel dtm= new DefaultTableModel(vData,ChatServer.getData());
			table.setModel(dtm);
		}else{
		}}else
	if(id.equals("0x113")){//�˳�������
		chatserver.closeserver();
		start.setText("����");
		start.setActionCommand("0x111");
		}
	}
    
	public static void main(String[] args) {
    	new ServiceWindow();
		
		
    		
    }

}
