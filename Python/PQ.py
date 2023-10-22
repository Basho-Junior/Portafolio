#Program by Junior Hernandez MAT. 20180999
class PriorityQueue:
    
    # Class constructor     
    def __init__(self):      
        # Members of  
        self.heap = [] 
        self.data_dict = {} 
 
        # Additional initialization code here

        
    # Insert or update item with priority and data given    
    def insert_or_update(self, priority, data):
        if data not in self.heap:
            self.data_dict[data] = priority
            self.heap.append(data)
            i = len(self.heap)-1
            if data in self.heap:
                i = self.heap.index(data)
            while(i != 0): 
                previous = self.data_dict[self.heap[i-1]]    
                if priority < previous:
                    self.heap[i] = self.heap[i-1]
                    self.heap[i-1] = data                    
                else:
                    break
                i -= 1
                     
        elif data in self.heap and priority < self.data_dict[data]:
            self.data_dict[data] = priority
            i = len(self.heap)-1
            if data in self.heap:
                i = self.heap.index(data)
            while(i != 0): 
                previous = self.data_dict[self.heap[i-1]]    
                if priority < previous:
                    self.heap[i] = self.heap[i-1]
                    self.heap[i-1] = data                    
                else:
                    break
                i -= 1

                
    # Extract element with lowest priority value    
    # Return the element as a tuple (priority, data)     
    def extract(self):
        if(self.heap.__len__() > 0):
            menor = self.heap[0]
            self.heap.remove(menor)
            return (self.data_dict[menor],menor)
        else:
            return None

         
    # Return the element with lowest priority
    #   as a tuple (priority, data)     # DO NOT REMOVE from queue     
    def peek(self):
        if(self.heap._len_()>0):
            menor = self.heap[0]
            return (self.data_dict[menor],menor)
        else:
            return None       

 
    # Return a string representing the internal state 
    def __str__(self):
        cadena = self.heap._str_()
        return cadena

         
    # Return number of elements in the queue
    def __len__(self):
        return len(self.heap)

 
    # Return True if queue is empty, False otherwise     
    def is_empty(self):
        if( len(self.heap) > 0 ):
            return False
        return True
        # Return queue is empty

