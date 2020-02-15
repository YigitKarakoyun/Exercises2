//------------------------------FORM TAŞIMA----------------------------------------
boolean isMove;
double mx, my;

    //-------------------------SÜRÜKLENME ZAMANINDA--------------------------------
    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        if (isMove){
        
         double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
         double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        
        this.setLocation((int)(mouseX-mx),(int)(mouseY-my));//Tuttuğun yerden taşıma

        //System.out.println("moved");
        }
    }                                 
    
//------------------------ TUTTUĞUNDA -----------------------------------------
    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
        isMove = true;

        mx = evt.getX();
        my = evt.getY();
        //System.out.println(mx+" "+my);
        //System.out.println("tıklandı "+ isMove);
    }                                 
//------------------------ BIRAKTIĞINDA----------------------------------------
    private void formMouseReleased(java.awt.event.MouseEvent evt) {                                   
        // TODO add your handling code here:
        isMove = false;
        //System.out.println("up");
    }                                  
//######################################################################################
