import java.util.*;
public class caixa  
{
        private double value;
        private int NProd;
        //adiciona valores
        public void addItem(double price)
        {
            value+=price;
            NProd++;
        }
    
        //retorna o total
        public double getTotal()
        {
            return value;
        }
    
        //retorna os ultimos valores inseridos
        public int GetCount()
        {
            return NProd;
        }
    
        //limpa o caixa
        public void clear()
        {
            value = 0;
            NProd = 0;     
        }
}
