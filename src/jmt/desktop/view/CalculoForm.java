package jmt.desktop.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jmt.desktop.controller.CalculoController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculoForm extends JFrame
{
	private JPanel contentPane;
	public JTextField txtCapital;
	public JTextField txtTaxa;
	public JTextField txtMeses;
	public JTextField txtMontante;
	public JRadioButton rdbtnTipoJurosSimples;
	public JRadioButton rdbtnTipoJurosCompostos;
	public JTextField txtTotalJuros;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					CalculoForm frame = new CalculoForm();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public CalculoForm()
	{
		setTitle("Cálculo de Juros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Capital");
		lblNewLabel.setBounds(10, 11, 46, 20);
		contentPane.add(lblNewLabel);

		txtCapital = new JTextField();
		txtCapital.setBounds(10, 30, 86, 20);
		contentPane.add(txtCapital);
		txtCapital.setColumns(10);

		JLabel lblCapital = new JLabel("Taxa % a.m.");
		lblCapital.setBounds(10, 55, 86, 20);
		contentPane.add(lblCapital);

		txtTaxa = new JTextField();
		txtTaxa.setColumns(10);
		txtTaxa.setBounds(10, 73, 86, 20);
		contentPane.add(txtTaxa);

		JLabel lblNDeMeses = new JLabel("N\u00B0 de meses");
		lblNDeMeses.setBounds(10, 98, 86, 20);
		contentPane.add(lblNDeMeses);

		txtMeses = new JTextField();
		txtMeses.setColumns(10);
		txtMeses.setBounds(10, 115, 86, 20);
		contentPane.add(txtMeses);

		JLabel lblTipoDeJuros = new JLabel("Tipo de juros");
		lblTipoDeJuros.setBounds(10, 146, 86, 20);
		contentPane.add(lblTipoDeJuros);

		rdbtnTipoJurosSimples = new JRadioButton("Simples");
		rdbtnTipoJurosSimples.setSelected(true);
		rdbtnTipoJurosSimples.setBounds(10, 162, 109, 23);
		contentPane.add(rdbtnTipoJurosSimples);

		rdbtnTipoJurosCompostos = new JRadioButton("Compostos");
		rdbtnTipoJurosCompostos.setBounds(120, 162, 109, 23);
		contentPane.add(rdbtnTipoJurosCompostos);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnTipoJurosCompostos);
		btnGroup.add(rdbtnTipoJurosSimples);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				onClickCalculo();
			}
		});
		btnCalcular.setBounds(253, 162, 89, 23);
		contentPane.add(btnCalcular);

		JLabel lblTotalDeJuros = new JLabel("Total de juros");
		lblTotalDeJuros.setBounds(10, 192, 86, 20);
		contentPane.add(lblTotalDeJuros);

		txtTotalJuros = new JTextField();
		txtTotalJuros.setColumns(10);
		txtTotalJuros.setBounds(10, 210, 192, 20);
		contentPane.add(txtTotalJuros);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 192, 327, 20);
		contentPane.add(separator);

		JLabel lblMontante = new JLabel("Montante");
		lblMontante.setBounds(10, 229, 86, 20);
		contentPane.add(lblMontante);

		txtMontante = new JTextField();
		txtMontante.setColumns(10);
		txtMontante.setBounds(10, 249, 192, 20);
		contentPane.add(txtMontante);
	}

	private void onClickCalculo()
	{
		CalculoController controller = new CalculoController();
		controller.executa(this);
	}
}
