package org.exoplatform.common.regex;/*
 * Copyright (C) 2011 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

import java.util.LinkedList;
import java.util.List;

/**
 * State of a Finite State Machine
 *
 * @author <a href="hoang281283@gmail.com">Minh Hoang TO</a>
 * @date 7/5/11
 */
public class State<C>
{

   private final String label;

   private final List<Transition<C>> transitions;

   private final boolean isFinal;

   private State(String label, boolean isFinal)
   {
      this.label = label;
      this.transitions = new LinkedList<Transition<C>>();
      this.isFinal = isFinal;
   }

   public static State getInstance(String label, boolean isFinal)
   {
      return new State(label, isFinal);
   }

   public void connectTo(C letter, State target)
   {
      Transition newTransition = new Transition(letter, this, target);

      for(Transition tran : transitions)
      {
         if(newTransition.equals(tran))
         {
            return;
         }
      }
      this.transitions.add(newTransition);
   }

   public State<C> findTargetState(C letter)
   {
      for(Transition tran : transitions)
      {
         if(tran.getLetter().equals(letter))
         {
            return tran.getTo();
         }
      }

      return null;
   }

   public String getLabel()
   {
      return this.label;
   }

   public boolean isFinal()
   {
      return this.isFinal;
   }

   @Override
   public int hashCode()
   {
      return ("" + label).hashCode();
   }
}
