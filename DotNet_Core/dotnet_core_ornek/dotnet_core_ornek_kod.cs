using System;
using System.Collections.Generic;

namespace vscode
{
    class Program
    {
        static void Main(string[] args)
        {
            setProgram();
        }
        static void setProgram(){
            Console.WriteLine("Alem efem");
            setFibonatci();
        }
        static void setFibonatci(){
            var generator = new FibonacciGenerator();
            foreach (var digit in generator.Generate(15))
            {
                Console.WriteLine(digit);
            }
 
        }
        
    }
     public class FibonacciGenerator
    {
        private System.Collections.Generic.Dictionary<int, int> _cache = new System.Collections.Generic.Dictionary<int, int>();
        
        private int Fib(int n) => n < 2 ? n : FibValue(n - 1) + FibValue(n - 2);
        
        private int FibValue(int n)
        {
            if (!_cache.ContainsKey(n))
            {
                _cache.Add(n, Fib(n));
            }
            
            return _cache[n];
        }
        
        public IEnumerable<int> Generate(int n)
        {
            for (int i = 0; i < n; i++)
            {
                yield return FibValue(i);
            }
        }
    }
}
