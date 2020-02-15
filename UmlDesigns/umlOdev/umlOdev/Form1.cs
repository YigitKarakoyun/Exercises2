using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace umlOdev
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
    }
    public class Customer
    {
        public string name { get; set; }
        public string address { get; set; }
    }
    public class Order
    {
        public List<Customer> Customers { get; set; } = new List<Customer>();
        public string date { get; set; }
        public string status { get; set; }
        public double clacTax(Payment payment)
        {
            return payment.amount;
        }
    }
    public abstract class Payment
    {
        public abstract double amount { get; set; };
    }
    public class Credit : Payment
    {
        public override double amount {
            get => throw new NotImplementedException();
            set => throw new NotImplementedException();
        }
        public int number { get; set; }
        public string type { get; set; }
        public string expDate { get; set; }

        internal string unathorized()
        {
            return "?";
        }
    }
    public class Cash : Payment
    {
        public override double amount {
            get => throw new NotImplementedException();
            set => throw new NotImplementedException();
        }
        public int cashTendered { get; set; }
    }
    public class Check : Payment
    {
        public override double amount {
            get => throw new NotImplementedException();
            set => throw new NotImplementedException();
        }
        public string name { get; set; }
        public int bankID { get; set; }
        public string authorized()
        {
            return "Yetkili";
        }
    }
    public class OrderDetail
    {
        public List<Order> Orders { get; set; } = new List<Order>();

        public int quantity { get; set; }
        public string taxStatus { get; set; }

        public List<Item> Items { get; set; } = new List<Item>();
        public double calcSubTotal(Item item)
        {
            return item.getPriceForQuantity() * item.getWeight();
        }
        public double calcWeight(Item item)
        {
            return item.getWeight();
        }
    }
    public class Item
    {
        public int shippingWeight { get; set; }
        public string description { get; set; }
        public int getPriceForQuantity()
        {
            return 1;
        }

        public int getWeight()
        {
            return 2;
        }
    }
}
