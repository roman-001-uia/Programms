import shutil
import os
import datetime

def backup_files(source, destination):
    timestamp = datetime.datetime.now().strftime("%Y%m%d_%H%M%S")
    backup_folder = os.path.join(destination, f"backup_{timestamp}")
    shutil.copytree(source, backup_folder)

