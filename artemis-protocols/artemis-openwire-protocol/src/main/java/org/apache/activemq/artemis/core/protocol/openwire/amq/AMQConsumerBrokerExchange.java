/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.artemis.core.protocol.openwire.amq;

import org.apache.activemq.command.MessageAck;
import org.apache.activemq.command.MessagePull;

public abstract class AMQConsumerBrokerExchange {

   protected final AMQSession amqSession;
   private AMQConnectionContext connectionContext;
   private boolean wildcard;

   public AMQConsumerBrokerExchange(AMQSession amqSession) {
      this.amqSession = amqSession;
   }

   /**
    * @return the connectionContext
    */
   public AMQConnectionContext getConnectionContext() {
      return this.connectionContext;
   }

   /**
    * @param connectionContext the connectionContext to set
    */
   public void setConnectionContext(AMQConnectionContext connectionContext) {
      this.connectionContext = connectionContext;
   }

   /**
    * @return the wildcard
    */
   public boolean isWildcard() {
      return this.wildcard;
   }

   /**
    * @param wildcard the wildcard to set
    */
   public void setWildcard(boolean wildcard) {
      this.wildcard = wildcard;
   }

   public abstract void acknowledge(MessageAck ack) throws Exception;

   public abstract void processMessagePull(MessagePull messagePull) throws Exception;

   public abstract void removeConsumer() throws Exception;
}
