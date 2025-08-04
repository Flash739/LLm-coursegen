# Use official Node image
FROM node:18-alpine

# Set working directory
WORKDIR /app

# Install dependencies
COPY package*.json ./
RUN npm install

# Copy all files
COPY . .

# Expose port used by react-scripts (default 3000)
EXPOSE 3000

# Start the dev server
CMD ["npm", "start"]
